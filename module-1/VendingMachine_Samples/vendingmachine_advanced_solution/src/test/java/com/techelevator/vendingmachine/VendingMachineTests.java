package com.techelevator.vendingmachine;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.changedispenser.ChangeDispenser;
import com.techelevator.changedispenser.Money;
import com.techelevator.purchasable.Slot;
import com.techelevator.purchasable.SlotDao;
import com.techelevator.purchasable.snack.Chip;
import com.techelevator.vendingmachine.Auditable;
import com.techelevator.vendingmachine.InsufficientFundsException;
import com.techelevator.vendingmachine.InvalidSlotLocationException;
import com.techelevator.vendingmachine.SoldOutException;
import com.techelevator.vendingmachine.VendingMachine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTests {
	private static final String FAKE_CHANGE_DISPENSER_RETURN_VALUE = "change was returned";
	private ChangeDispenser changeDispenser;
	private VendingMachine vendingMachine;
	private FakeAuditLog fakeAuditLog;
	private FakeSlotDao fakeSlotDao;
	
	@Before
	public void setup() {
		changeDispenser = new FakeChangeDispenser();
		fakeAuditLog = new FakeAuditLog();
		fakeSlotDao = new FakeSlotDao();
		vendingMachine = new VendingMachine(changeDispenser, fakeAuditLog, fakeSlotDao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void null_change_dispenser_throws() {
		// Act
		vendingMachine = new VendingMachine(null, fakeAuditLog, fakeSlotDao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void null_audit_log_throws() {
		// Act
		vendingMachine = new VendingMachine(changeDispenser, null, fakeSlotDao);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void null_slot_dao_throws() {
		// Act
		vendingMachine = new VendingMachine(changeDispenser, fakeAuditLog, null);
	}

	@Test
	public void feedMoney_negative_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(-1));

		// Assert
		Assert.assertFalse(fakeAuditLog.wasMoneyFed());
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_unacceptable_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(100));

		// Assert
		Assert.assertFalse(fakeAuditLog.wasMoneyFed());
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_null_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(null);

		// Assert
		Assert.assertFalse(fakeAuditLog.wasMoneyFed());
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_once_increases_balance() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.ONE);

		// Assert
		Assert.assertTrue(acceptedPayment);
		Assert.assertTrue(fakeAuditLog.wasMoneyFed());
		Assert.assertEquals(BigDecimal.ONE, vendingMachine.getBalance());
	}

	@Test
	public void feedMoney_many_times_increases_balance() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.ONE);
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(2));
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(5));
		acceptedPayment &= vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Assert
		Assert.assertTrue(acceptedPayment);
		Assert.assertTrue(fakeAuditLog.wasMoneyFed());
		Assert.assertEquals(BigDecimal.valueOf(18), vendingMachine.getBalance());
	}

	@Test
	public void toString_displays_items() {
		// Arrange
		String expected = "A1 Frito Lay $1.00, 2 remaining.\n";

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void toString_displays_sold_out() {
		// Arrange
		String expected = "A1 Sold Out\n";

		// Feed 20 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Vend 2 out of 2 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_invalid_slot_rejects() {
		// Arrange

		// Act
		vendingMachine.purchaseItem("");

		// Assert
		Assert.assertFalse(fakeAuditLog.wasSnackVended());
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_null_slot_rejects() {
		// Arrange

		// Act
		vendingMachine.purchaseItem(null);

		// Assert
		Assert.assertFalse(fakeAuditLog.wasSnackVended());
	}

	@Test
	public void purchaseItem_sold_out_slot_rejects() {
		// Arrange
		boolean soldOut = false;

		// Feed 20 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(2));

		// Vend 2 out of 2 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		try {
			vendingMachine.purchaseItem("A1"); // vending again causes exception
		} catch (SoldOutException ex) {
			soldOut = true;
		}

		Assert.assertTrue(soldOut);
		Assert.assertEquals(2, fakeAuditLog.getSnackVendedCount());
	}

	@Test
	public void purchaseItem_insufficient_funds_rejects() {
		// Arrange
		boolean insufficientFunds = false;

		// Act
		try {
			vendingMachine.purchaseItem("A1");
		} catch (InsufficientFundsException ex) {
			insufficientFunds = true;
		}

		// Assert
		Assert.assertTrue(insufficientFunds);
		Assert.assertFalse(fakeAuditLog.wasSnackVended());
	}

	@Test
	public void purchaseItem_reduces_balance() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		vendingMachine.purchaseItem("A1");

		// Assert
		Assert.assertEquals(BigDecimal.valueOf(9), vendingMachine.getBalance());
	}

	@Test
	public void finishTransaction_reduces_balance_to_zero() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		vendingMachine.finishTransaction();

		// Assert
		Assert.assertEquals(BigDecimal.ZERO, vendingMachine.getBalance());
	}

	@Test
	public void finishTransaction_gets_change() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		String change = vendingMachine.finishTransaction();

		// Assert
		Assert.assertEquals(FAKE_CHANGE_DISPENSER_RETURN_VALUE, change);
	}

	@Test
	public void finishTransaction_is_audited() {
		// Arrange

		// Act
		vendingMachine.finishTransaction();

		// Assert
		Assert.assertTrue(fakeAuditLog.wasChangeGiven());
	}
	
	private class FakeSlotDao implements SlotDao {
		
		@Override
		public Map<String, Slot> getAllSlots() {
			Map<String, Slot> map = new LinkedHashMap<>();
			
			Slot slot = new Slot("A1");
			
			slot.addItem(new Chip("Frito Lay", BigDecimal.ONE));
			slot.addItem(new Chip("Frito Lay", BigDecimal.ONE));
			
			map.put("A1", slot);
			
			return map;
		}
	}

	private class FakeChangeDispenser implements ChangeDispenser {

		@Override
		public void setAcceptedMoney(Money[] acceptedMoney) {

		}

		@Override
		public String makeChange(BigDecimal amount) {
			return FAKE_CHANGE_DISPENSER_RETURN_VALUE;
		}

	}

	private class FakeAuditLog implements Auditable {
		private boolean wasMoneyFed = false;
		private boolean wasChangeGiven = false;
		private int snackVendedCount = 0;

		@Override
		public void moneyFed(BigDecimal amountAdded, BigDecimal balance) {
			wasMoneyFed = true;
		}

		public boolean wasMoneyFed() {
			return wasMoneyFed;
		}

		@Override
		public void snackVended(String slotName, String snackName, BigDecimal priorBalance, BigDecimal currentBalance) {
			snackVendedCount++;
		}

		public boolean wasSnackVended() {
			return getSnackVendedCount() > 0;
		}

		public int getSnackVendedCount() {
			return snackVendedCount;
		}

		@Override
		public void changeGiven(BigDecimal amount) {
			wasChangeGiven = true;
		}

		public boolean wasChangeGiven() {
			return wasChangeGiven;
		}
	}
}
