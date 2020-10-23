package com.techelevator;

import java.io.File;

import com.techelevator.changedispenser.ChangeDispenser;
import com.techelevator.changedispenser.FewestCoinsChangeDispenser;
import com.techelevator.purchasable.SlotDao;
import com.techelevator.purchasable.snack.DelimitedFileSlotDao;
import com.techelevator.vendingmachine.AuditLog;
import com.techelevator.vendingmachine.Auditable;
import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.vendingmachine.view.PurchaseMenuCLI;
import com.techelevator.vendingmachine.view.VendingMachineCLI;
import com.techelevator.view.Menu;

public class Application {

	public static void main(String[] args) {

		// Set up vending machine dependencies.
		ChangeDispenser changeDispenser = new FewestCoinsChangeDispenser();
		Auditable auditLog = new AuditLog(new File("Log.txt"));
		SlotDao slotDao = new DelimitedFileSlotDao(new File("vendingmachine.csv"));

		// Create vending machine
		VendingMachine vendingMachine = new VendingMachine(changeDispenser, auditLog, slotDao);

		// Create CLIs
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenuCLI purchaseMenuCLI = new PurchaseMenuCLI(menu, vendingMachine);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenuCLI, vendingMachine);

		// Begin
		cli.run();
	}

}
