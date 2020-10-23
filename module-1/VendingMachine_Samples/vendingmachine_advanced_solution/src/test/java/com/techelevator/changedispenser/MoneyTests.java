package com.techelevator.changedispenser;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoneyTests {

	@Test
	public void construct_money_without_name_defaults_to_blank() {
		// Arrange

		// Act
		Money money = new Money(null, BigDecimal.ONE);

		// Assert
		Assert.assertEquals("", money.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void construct_money_without_value_throws() {
		new Money("", null);
	}

}
