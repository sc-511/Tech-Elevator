package com.techelevator.vendingmachine;

import java.math.BigDecimal;

public interface Auditable {

	/**
	 * Indicate that there was money fed.
	 * 
	 * @param amountAdded The amount of money that was added.
	 * @param balance     The resulting balance after money was added.
	 */
	void moneyFed(BigDecimal amountAdded, BigDecimal balance);

	/**
	 * Indicate that there was a snack vended.
	 * 
	 * @param slotName       The name of the slot that the snack was vended from.
	 * @param snackName      The name of the snack that was vended.
	 * @param priorBalance   The balance prior to vending the snack.
	 * @param currentBalance The balance after vending the snack.
	 */
	void snackVended(String slotName, String snackName, BigDecimal priorBalance, BigDecimal currentBalance);

	/**
	 * Indicate that change was returned for the remaining balance.
	 * 
	 * @param amount The amount of change that was returned.
	 */
	void changeGiven(BigDecimal amount);
}
