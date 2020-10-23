package com.techelevator.changedispenser;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A ChangeDispenser that will return the fewest coins possible.
 */
public class FewestCoinsChangeDispenser implements ChangeDispenser {
	private Money[] acceptedMoney = new Money[0];
	private final DescendingMoneyComparator DESCENDING_MONEY_COMPARATOR = new DescendingMoneyComparator();

	@Override
	public String makeChange(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			return "Invalid amount";
		} else if (amount.compareTo(BigDecimal.ZERO) == 0) {
			return "No change";
		}

		String changeString = "";

		for (Money moneyType : acceptedMoney) {
			int howMany = 0;

			while (amount.compareTo(moneyType.getValue()) >= 0) {
				howMany += 1;
				amount = amount.subtract(moneyType.getValue());
			}

			if (howMany == 1) {
				changeString += howMany + " " + moneyType.getName() + " ";
			} else if (howMany > 1) {
				changeString += howMany + " " + moneyType.getName() + "s ";
			}
		}

		return changeString.substring(0, changeString.length() - 1); // remove last space
	}

	@Override
	public void setAcceptedMoney(Money[] acceptedMoney) {
		this.acceptedMoney = acceptedMoney;

		Arrays.sort(this.acceptedMoney, DESCENDING_MONEY_COMPARATOR);
	}

	/**
	 * Used to sort Money in descending order of the value.
	 */
	private class DescendingMoneyComparator implements Comparator<Money> {
		@Override
		public int compare(Money o1, Money o2) {
			return o2.getValue().compareTo(o1.getValue());
		}
	}
}
