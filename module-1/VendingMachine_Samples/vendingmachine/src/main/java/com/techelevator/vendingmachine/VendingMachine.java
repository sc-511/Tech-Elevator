package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.MoneyFormatter;
import com.techelevator.snack.Snack;
import com.techelevator.vendingmachine.Slot;

public class VendingMachine {
	private BigDecimal balance;
	private File logFile;
	private Map<String, Slot> slots;

	/**
	 * Get the balance remaining.
	 * 
	 * @return The balance remaining.
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	public VendingMachine() {
		balance = new BigDecimal(0.00);
		logFile = new File("Log.txt");
		slots = getInventory();
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
	 * Attempt to feed money into the machine.
	 * 
	 * @param amount The amount of money to feed.
	 * @return True if money was successfully added. False otherwise.
	 */
	public boolean feedMoney(BigDecimal amount) {
		if (!isValidAmount(amount))
			return false;

		balance = balance.add(amount);

		String logMsg = "FEED MONEY " + MoneyFormatter.formatMoney(amount) + " " + MoneyFormatter.formatMoney(balance);
		writeLog(logMsg);

		return true;
	}

	private boolean isValidAmount(BigDecimal amount) {
		if (amount == null)
			return false;

		if (amount.compareTo(BigDecimal.valueOf(1)) == 0) { // 1 Dollar
			return true;
		} else if (amount.compareTo(BigDecimal.valueOf(2)) == 0) { // 2 Dollars
			return true;
		} else if (amount.compareTo(BigDecimal.valueOf(5)) == 0) { // 5 Dollars
			return true;
		} else if (amount.compareTo(BigDecimal.valueOf(10)) == 0) { // 10 Dollars
			return true;
		}

		return false;
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

		Snack item = slot.vend();
		BigDecimal balancePrior = balance;
		balance = balance.subtract(item.getPrice());

		String logMsg = slotName + " " + item.getName() + " " + MoneyFormatter.formatMoney(balancePrior) + " "
				+ MoneyFormatter.formatMoney(balance);
		writeLog(logMsg);

		return item.toString() + "\nRemaining Balance: " + MoneyFormatter.formatMoney(getBalance());
	}

	/**
	 * Finish the transaction and return change to the consumer.
	 * 
	 * @return The amount of change the consumer is owed using the fewest coins
	 *         possible.
	 */
	public String finishTransaction() {
		String changeString = makeChange(balance);

		String logMsg = "GIVE CHANGE " + MoneyFormatter.formatMoney(balance) + " "
				+ MoneyFormatter.formatMoney(BigDecimal.ZERO);

		writeLog(logMsg);

		balance = BigDecimal.ZERO;

		return changeString;
	}

	private Map<String, Slot> getInventory() {
		Map<String, Slot> slots = new LinkedHashMap<>();

		try (Scanner fileScanner = new Scanner(new File("vendingmachine.csv"))) {
			int lineCounter = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineCounter++;
				String[] lineParts = line.split("\\|");

				if (lineParts.length < 4 || lineParts[2] == null) {
					throw new IllegalArgumentException("Invalid file format on line " + lineCounter);
				}

				String slotName = lineParts[0];
				String snackName = lineParts[1];
				double snackPrice = Double.parseDouble(lineParts[2]);
				String snackType = lineParts[3];

				Snack snack = Snack.createSnackForType(snackType, snackName, BigDecimal.valueOf(snackPrice));

				Slot theSlot;
				if (slots.containsKey(slotName)) {
					theSlot = slots.get(slotName);
				} else {
					theSlot = new Slot(slotName);
					slots.put(slotName, theSlot);
				}

				// Add 5 of the Snacks to the Slot
				for (int i = 1; i <= 5; i++) {
					theSlot.addItem(snack);
				}
			}
		} catch (FileNotFoundException e) {
			return null;
		}

		return slots;
	}

	private String makeChange(BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			return "Invalid amount";
		} else if (amount.compareTo(BigDecimal.ZERO) == 0) {
			return "No change";
		}

		String changeString = "";
		int howMany;

		// Quarters
		howMany = 0;
		BigDecimal QUARTER = BigDecimal.valueOf(0.25);
		while (amount.compareTo(QUARTER) >= 0) {
			howMany += 1;
			amount = amount.subtract(QUARTER);
		}

		if (howMany == 1) {
			changeString += howMany + " quarter ";
		} else if (howMany > 1) {
			changeString += howMany + " quarters ";
		}

		// Dimes
		howMany = 0;
		BigDecimal DIME = BigDecimal.valueOf(0.1);
		while (amount.compareTo(DIME) >= 0) {
			howMany += 1;
			amount = amount.subtract(DIME);
		}

		if (howMany == 1) {
			changeString += howMany + " dime ";
		} else if (howMany > 1) {
			changeString += howMany + " dimes ";
		}

		// Nickels
		howMany = 0;
		BigDecimal NICKEL = BigDecimal.valueOf(0.05);
		while (amount.compareTo(NICKEL) >= 0) {
			howMany += 1;
			amount = amount.subtract(NICKEL);
		}

		if (howMany == 1) {
			changeString += howMany + " nickel ";
		} else if (howMany > 1) {
			changeString += howMany + " nickels ";
		}

		return changeString.substring(0, changeString.length() - 1); // remove last space
	}

	private void writeLog(String log) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {
			writer.println(LocalDateTime.now() + " " + log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
