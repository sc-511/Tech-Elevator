package com.techelevator.purchasable;

import java.math.BigDecimal;

public interface Purchasable {
	/**
	 * Get the name of the purchasable item.
	 * 
	 * @return The name of the purchasable item.
	 */
	public String getName();
	
	/**
	 * Get the price of the purchasable item.
	 * 
	 * @return The price of the purchasable item.
	 */
	public BigDecimal getPrice();
}
