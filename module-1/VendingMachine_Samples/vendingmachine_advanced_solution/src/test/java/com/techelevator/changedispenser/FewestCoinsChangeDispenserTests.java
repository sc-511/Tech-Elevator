package com.techelevator.changedispenser;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.changedispenser.FewestCoinsChangeDispenser;
import com.techelevator.vendingmachine.VendingMachine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FewestCoinsChangeDispenserTests {

	private FewestCoinsChangeDispenser changeMaker;

	@Before
	public void setup() {
		changeMaker = new FewestCoinsChangeDispenser();
		changeMaker.setAcceptedMoney(VendingMachine.CHANGE_POSSIBILITES);
	}

	@Test
	public void makeChange_invalid() {
		// Arrange
		final String expected = "Invalid amount";

		// Act
		String actual = changeMaker.makeChange(BigDecimal.valueOf(-1));

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void makeChange_zero() {
		// Arrange
		final String expected = "No change";

		// Act
		String actual = changeMaker.makeChange(BigDecimal.ZERO);

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void makeChange_one_dollar_thirty_one() {
		// Arrange
		final String expected = "5 quarters 1 nickel";
		final BigDecimal amount = BigDecimal.valueOf(1.30);

		// Act
		String actual = changeMaker.makeChange(amount);

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void makeChange_one_quarter() {
		// Arrange
		final String expected = "1 quarter";

		// Act
		String actual = changeMaker.makeChange(BigDecimal.valueOf(.25));

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void makeChange_one_dime() {
		// Arrange
		final String expected = "1 dime";

		// Act
		String actual = changeMaker.makeChange(BigDecimal.valueOf(.1));

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void makeChange_one_nickel() {
		// Arrange
		final String expected = "1 nickel";

		// Act
		String actual = changeMaker.makeChange(BigDecimal.valueOf(.05));

		// Assert
		Assert.assertEquals(expected, actual);
	}
}