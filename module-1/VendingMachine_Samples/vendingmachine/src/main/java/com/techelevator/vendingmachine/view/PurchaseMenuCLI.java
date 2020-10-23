package com.techelevator.vendingmachine.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.MoneyFormatter;
import com.techelevator.vendingmachine.InsufficientFundsException;
import com.techelevator.vendingmachine.InvalidSlotLocationException;
import com.techelevator.vendingmachine.SoldOutException;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.view.Menu;

public class PurchaseMenuCLI {
	private static final String MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MENU_OPTION_FINISH = "Finish Transaction";

	private static final String[] MENU_OPTIONS = { MENU_OPTION_FEED_MONEY, MENU_OPTION_SELECT_PRODUCT,
			MENU_OPTION_FINISH };

	private Menu menu;
	private VendingMachine vendingMachine;
	private Scanner keyboardInput = new Scanner(System.in);

	public PurchaseMenuCLI(Menu menu, VendingMachine vendingMachine) {
		this.menu = menu;
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		boolean finishedWithPurchase = false;
		do {
			System.out.println();
			System.out.println("Current Money Provided: " + MoneyFormatter.formatMoney(vendingMachine.getBalance()));

			String subMenuChoice = (String) menu.getChoiceFromOptions(MENU_OPTIONS);

			switch (subMenuChoice) {
			case MENU_OPTION_FEED_MONEY:

				boolean moneyAccepted = false;
				do {
					BigDecimal amount = getAmountToFeed();
					moneyAccepted = vendingMachine.feedMoney(amount);
					if (!moneyAccepted) {
						System.out.println("Invalid amount");
					}
				} while (!moneyAccepted);

				break;
			case MENU_OPTION_SELECT_PRODUCT:

				System.out.println(vendingMachine.toString()); // display items once for them to review
				boolean tryAgain;

				do {
					try {
						tryAgain = false;

						String slotName = getSlotName();
						String purchaseOutput = vendingMachine.purchaseItem(slotName);

						System.out.println();
						System.out.println(purchaseOutput);

					} catch (SoldOutException e) {
						System.out.println("This item is sold out. Please make another selection.");
						tryAgain = true;
					} catch (InvalidSlotLocationException e) {
						System.out.println("You have chosen an invalid slot location. Please make another selection.");
						tryAgain = true;
					} catch (InsufficientFundsException e) {
						System.out.println("Insufficient funds. Please feed money to make this purchase.");
						tryAgain = false;
					}

				} while (tryAgain);

				break;
			case MENU_OPTION_FINISH:
				System.out.println("Change given: " + vendingMachine.finishTransaction());
				finishedWithPurchase = true;
				break;
			}

		} while (!finishedWithPurchase);
	}

	private String getSlotName() {
		System.out.print("Choose a slot: ");
		return keyboardInput.nextLine();
	}

	private BigDecimal getAmountToFeed() {
		System.out.print("How much ($1, $2, $5, $10)? ");
		String line = keyboardInput.nextLine();

		line = MoneyFormatter.removeCurrencySymbol(line);

		double amountAsDouble;

		try {
			amountAsDouble = Double.parseDouble(line);

		} catch (NumberFormatException e) {
			return BigDecimal.valueOf(-1); // invalid amount
		}

		return BigDecimal.valueOf(amountAsDouble);
	}
}
