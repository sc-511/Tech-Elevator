package com.techelevator.changedispenser;

import java.math.BigDecimal;

public interface ChangeDispenser {
	
	/**
	 * Set the accepted money for the ChangeDispenser.
	 * 
	 * @param acceptedMoney The accepted money.
	 */
	public void setAcceptedMoney(Money[] acceptedMoney);
	
	/**
	 * Calculate and return change to the user.
	 * 
	 * @param amount The amount of money to begin with.
	 * @return The amount of change that is returned.
	 */
	public String makeChange(BigDecimal amount);
}
