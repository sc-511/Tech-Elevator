package com.techelevator.vendingmachine;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.vendingmachine.InsufficientFundsException;
import com.techelevator.vendingmachine.InvalidSlotLocationException;
import com.techelevator.vendingmachine.SoldOutException;
import com.techelevator.vendingmachine.VendingMachine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTests {
	private VendingMachine vendingMachine;

	@Before
	public void setup() {
		vendingMachine = new VendingMachine();
	}

	@Test
	public void feedMoney_negative_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(-1));

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_unacceptable_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.valueOf(100));

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_null_amount_rejects() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(null);

		// Assert
		Assert.assertFalse(acceptedPayment);
	}

	@Test
	public void feedMoney_once_increases_balance() {
		// Arrange

		// Act
		boolean acceptedPayment = vendingMachine.feedMoney(BigDecimal.ONE);

		// Assert
		Assert.assertTrue(acceptedPayment);
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
		Assert.assertEquals(BigDecimal.valueOf(18), vendingMachine.getBalance());
	}

	@Test
	public void toString_displays_items() {
		// Arrange
		String expected = "A1 Potato Crisps $3.05, 5 remaining.\n" +
				"A2 Stackers $1.45, 5 remaining.\n" +
				"A3 Grain Waves $2.75, 5 remaining.\n" +
				"A4 Cloud Popcorn $3.65, 5 remaining.\n" + 
				"B1 Moonpie $1.80, 5 remaining.\n" + 
				"B2 Cowtales $1.50, 5 remaining.\n" + 
				"B3 Wonka Bar $1.50, 5 remaining.\n" + 
				"B4 Crunchie $1.75, 5 remaining.\n" + 
				"C1 Cola $1.25, 5 remaining.\n" + 
				"C2 Dr. Salt $1.50, 5 remaining.\n" + 
				"C3 Mountain Melter $1.50, 5 remaining.\n" + 
				"C4 Heavy $1.50, 5 remaining.\n" + 
				"D1 U-Chews $0.85, 5 remaining.\n" + 
				"D2 Little League Chew $0.95, 5 remaining.\n" + 
				"D3 Chiclets $0.75, 5 remaining.\n" + 
				"D4 Triplemint $0.75, 5 remaining.\n";

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}
				
	@Test
	public void toString_displays_sold_out() {
		// Arrange
		String expected = "A1 Sold Out\n" +
				"A2 Stackers $1.45, 5 remaining.\n" +
				"A3 Grain Waves $2.75, 5 remaining.\n" +
				"A4 Cloud Popcorn $3.65, 5 remaining.\n" + 
				"B1 Moonpie $1.80, 5 remaining.\n" + 
				"B2 Cowtales $1.50, 5 remaining.\n" + 
				"B3 Wonka Bar $1.50, 5 remaining.\n" + 
				"B4 Crunchie $1.75, 5 remaining.\n" + 
				"C1 Cola $1.25, 5 remaining.\n" + 
				"C2 Dr. Salt $1.50, 5 remaining.\n" + 
				"C3 Mountain Melter $1.50, 5 remaining.\n" + 
				"C4 Heavy $1.50, 5 remaining.\n" + 
				"D1 U-Chews $0.85, 5 remaining.\n" + 
				"D2 Little League Chew $0.95, 5 remaining.\n" + 
				"D3 Chiclets $0.75, 5 remaining.\n" + 
				"D4 Triplemint $0.75, 5 remaining.\n";

		// Feed 20 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(10));
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Vend 5 out of 5 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		String actual = vendingMachine.toString();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_invalid_slot_rejects() {
		vendingMachine.purchaseItem("");
	}

	@Test(expected = InvalidSlotLocationException.class)
	public void purchaseItem_null_slot_rejects() {
		vendingMachine.purchaseItem(null);
	}

	@Test(expected = SoldOutException.class)
	public void purchaseItem_sold_out_slot_rejects() {
		// Arrange
		
		// Feed 20 dollars
		vendingMachine.feedMoney(BigDecimal.valueOf(10));
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Vend 5 out of 5 items
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");
		vendingMachine.purchaseItem("A1");

		// Act
		vendingMachine.purchaseItem("A1"); // vending again causes exception
	}

	@Test(expected = InsufficientFundsException.class)
	public void purchaseItem_insufficient_funds_rejects() {
		vendingMachine.purchaseItem("A1");
	}

	@Test
	public void purchaseItem_reduces_balance() {
		// Arrange
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		vendingMachine.purchaseItem("A1");

		// Assert
		Assert.assertEquals(BigDecimal.valueOf(6.95), vendingMachine.getBalance());
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
	public void finishTransaction_prefers_quarters_over_other_coins() {
		// Arrange
		String expectedChange = "40 quarters";
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		// Act
		String change = vendingMachine.finishTransaction();

		// Assert
		Assert.assertEquals(expectedChange, change);
	}
	
	@Test
	public void finishTransaction_gets_quarters_dimes_nickels() {
		// Arrange
		String expectedChange = "28 quarters 1 dime 1 nickel";
		vendingMachine.feedMoney(BigDecimal.valueOf(10));

		vendingMachine.purchaseItem("D2");
		vendingMachine.purchaseItem("D2");
		vendingMachine.purchaseItem("D2");

		// Act
		String change = vendingMachine.finishTransaction();

		// Assert
		Assert.assertEquals(expectedChange, change);
	}

//	@Test
//	public void finishTransaction_is_audited() {
//		// Arrange
//
//		// Act
//		vendingMachine.finishTransaction();
//
//		// Assert
//		Assert.assertTrue(fakeAuditLog.wasChangeGiven());
//	}
}
