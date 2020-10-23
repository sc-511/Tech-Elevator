package com.techelevator.vendingmachine;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techelevator.MoneyFormatter;
import com.techelevator.changedispenser.ChangeDispenser;
import com.techelevator.changedispenser.Money;
import com.techelevator.purchasable.Purchasable;
import com.techelevator.purchasable.Slot;
import com.techelevator.purchasable.SlotDao;

public class VendingMachine {
	private static final Money QUARTER = new Money("quarter", BigDecimal.valueOf(.25));
	private static final Money DIME = new Money("dime", BigDecimal.valueOf(.1));
	private static final Money NICKEL = new Money("nickel", BigDecimal.valueOf(.05));

	public static final Money[] CHANGE_POSSIBILITES = { QUARTER, DIME, NICKEL };
	public static final BigDecimal[] ACCEPTED_MONEY = { BigDecimal.valueOf(1), BigDecimal.valueOf(2),
			BigDecimal.valueOf(5), BigDecimal.valueOf(10) };

	private Map<String, Slot> slots;
	private Auditable auditLog;
	private BigDecimal balance;
	private ChangeDispenser changeDispenser;

	/**
	 * Get the balance remaining.
	 * 
	 * @return The balance remaining.
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	public VendingMachine(ChangeDispenser changeDispenser, Auditable auditLog, SlotDao slotDao) {
		slots = new LinkedHashMap<String, Slot>();
		this.balance = new BigDecimal(0.00);

		if (auditLog == null) {
			throw new IllegalArgumentException("auditLog cannot be null");
		}
		this.auditLog = auditLog;

		if (changeDispenser == null) {
			throw new IllegalArgumentException("changeDispenser cannot be null");
		}
		this.changeDispenser = changeDispenser;
		this.changeDispenser.setAcceptedMoney(CHANGE_POSSIBILITES);

		if (slotDao == null) {
			throw new IllegalArgumentException("slotDao cannot be null.");
		}

		slots = slotDao.getAllSlots();
	}

	/**
	 * Attempt to feed money into the machine.
	 * 
	 * @param amount The amount of money to feed.
	 * @return True if money was successfully added. False otherwise.
	 */
	public boolean feedMoney(BigDecimal amount) {
		if (!isValidAmount(amount))
			return false;

		balance = balance.add(amount);
		auditLog.moneyFed(amount, balance);

		return true;
	}

	private boolean isValidAmount(BigDecimal amount) {
		if (amount == null)
			return false;

		for (BigDecimal money : ACCEPTED_MONEY) {
			if (amount.compareTo(money) == 0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		String displayString = "";
		for (String slotName : slots.keySet()) {
			Slot currSlot = slots.get(slotName);

			displayString += currSlot.toString() + "\n";
		}

		return displayString;
	}

	/**
	 * Purchase an item from a slot within the machine.
	 * 
	 * @param slotName The name of the slot to purchase from.
	 * @return Details about the purchase
	 */
	public String purchaseItem(String slotName) {
		if (slotName == null || !slots.containsKey(slotName)) {
			throw new InvalidSlotLocationException(slotName + " is invalid");
		}

		Slot slot = slots.get(slotName);

		if (slot.getQuantity() == 0) {
			throw new SoldOutException();
		}

		if (balance.compareTo(slot.getPrice()) == -1) {
			throw new InsufficientFundsException();
		}

		Purchasable item = slot.vend();
		BigDecimal balancePrior = balance;
		balance = balance.subtract(item.getPrice());

		auditLog.snackVended(slotName, item.getName(), balancePrior, balance);

		return item.toString() + "\nRemaining Balance: " + MoneyFormatter.formatMoney(getBalance());
	}

	/**
	 * Finish the transaction and return change to the consumer.
	 * 
	 * @return The amount of change the consumer is owed using the fewest coins
	 *         possible.
	 */
	public String finishTransaction() {
		String changeString = changeDispenser.makeChange(balance);

		auditLog.changeGiven(balance);
		balance = BigDecimal.ZERO;

		return changeString;
	}
}
