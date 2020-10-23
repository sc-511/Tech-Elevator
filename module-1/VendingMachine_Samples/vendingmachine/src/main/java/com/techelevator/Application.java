package com.techelevator;

import com.techelevator.vendingmachine.VendingMachine;
import com.techelevator.vendingmachine.view.PurchaseMenuCLI;
import com.techelevator.vendingmachine.view.VendingMachineCLI;
import com.techelevator.view.Menu;

public class Application {

	public static void main(String[] args) {
		// Create vending machine
		VendingMachine vendingMachine = new VendingMachine();

		// Create CLIs
		Menu menu = new Menu(System.in, System.out);
		PurchaseMenuCLI purchaseMenuCLI = new PurchaseMenuCLI(menu, vendingMachine);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenuCLI, vendingMachine);

		// Begin
		cli.run();
	}

}
