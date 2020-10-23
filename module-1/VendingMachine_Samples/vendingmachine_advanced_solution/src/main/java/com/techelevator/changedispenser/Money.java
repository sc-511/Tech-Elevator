package com.techelevator.changedispenser;

import java.math.BigDecimal;

public class Money {
	private String name;
	private BigDecimal value;

	/**
	 * Create Money
	 * 
	 * @param name  The name for the valuation of the Money e.g. Dollar.
	 * @param value The value of the Money.
	 */
	public Money(String name, BigDecimal value) {
		if (name == null) {
			name = "";
		}

		if (value == null) {
			throw new IllegalArgumentException("value cannot by null");
		}

		this.name = name;
		this.value = value;
	}

	/**
	 * Get the name for the valuation of the money.
	 * 
	 * @return The name for the valuation of the money.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the value of the Money.
	 * 
	 * @return The value of the Money.
	 */
	public BigDecimal getValue() {
		return value;
	}
}
