package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterfaceFinal {
	
	public static void main (String[] args) {
		
	VendingMachine myVendingMachine = new VendingMachine();	
	Scanner userInput = new Scanner (System.in);
	boolean mainMenuRepetition = true;
	boolean subMenuRepetition = true;
	String action = "";
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	File output = new File ("log.txt");
	double moneyFed = 0.00;
	int userChoice;
	int subMenuUserChoice;
	double moneyFedBeforeChange = 0.00;
	double moneyFedBeforeTransaction = 0;
	

	try(PrintWriter pw = new PrintWriter (new FileWriter(output, true))){
		
	while (mainMenuRepetition) {
		
		System.out.println("====WELCOME TO VENDOR====");
		System.out.println(myVendingMachine.getMenuDisplay());
		System.out.println(myVendingMachine.getMenuPurchase());
		System.out.println(myVendingMachine.getMenuExit());
		System.out.println("==========================");
		userChoice = userInput.nextInt();
		subMenuRepetition = true;
	
	switch (userChoice) {
	
	case 1: 
			myVendingMachine.displayItems();
			break;
	
	
	case 2:
			while (subMenuRepetition) {
				
				System.out.println("==========================");
				System.out.println(myVendingMachine.getFeedMoney());
				System.out.println(myVendingMachine.getSelectItem());
				System.out.println(myVendingMachine.getFinishTransaction());
				System.out.println("\nCurrent Money Provided: $" + Math.floor(myVendingMachine.getTotalFeedCount() * 100) /100);
				System.out.println("==========================");
				subMenuRepetition = true;
				subMenuUserChoice = userInput.nextInt();
				
			
			switch (subMenuUserChoice) {
			
			case 1:

				System.out.println("Please insert a $1, $2, $5, or $10.");
				int moneyInserted = userInput.nextInt();
				myVendingMachine.feedMoney(moneyInserted);
				moneyFed += moneyInserted;
				action = "Feed Money: " + "$" + moneyInserted + " " + "$" + moneyFed;
				pw.println(dtf.format(now) + " " + action);
				pw.flush();
				break;
			
			case 2:
				
				if (moneyFed == 0) {
					System.out.println("No money fed. Please feed money before selecting a product.");
					break;
				}
				
				System.out.println("Please enter the slot for the item you wish to purchase (use capital letter).");
				String productSelector = userInput.next();
				
				if (myVendingMachine.getItem(productSelector) == null
						|| myVendingMachine.getItem(productSelector).isEmpty()
						|| myVendingMachine.getItemPrice(productSelector) == -1) {
					System.out.println("Product not found. Please select new product.");
					break;
				}
				else if (myVendingMachine.getItemPrice(productSelector) > myVendingMachine.getTotalFeedCount()){
					System.out.println("Not enough money fed. Please feed more money for product or select a new product.");
					break;
				} else if (myVendingMachine.getItemQuantity(productSelector) == 0) {
					System.out.println("Product sold out. Please select new product for purchase.");
					break; 
				} 
				
				else {
					
					moneyFedBeforeTransaction = myVendingMachine.getTotalFeedCount();
					moneyFedBeforeChange = myVendingMachine.deductBalance(myVendingMachine.getItemPrice(productSelector));
					moneyFedBeforeChange = Math.floor(moneyFedBeforeChange * 100) /100;
					myVendingMachine.deductItemQuantity(productSelector);
				}
				
				System.out.println("Purchase complete. Your items dispensed: " + myVendingMachine.getItem(productSelector) + " $" + Math.floor(myVendingMachine.getItemPrice(productSelector) * 100) /100);
				System.out.println(myVendingMachine.getSound(productSelector));
				action = "Transaction: " +  myVendingMachine.getItem(productSelector) + " " + productSelector + " " + "$" + Math.floor( moneyFedBeforeTransaction * 100) /100 + " " + "$" + moneyFedBeforeChange;
				pw.println(dtf.format(now) + " " + action);
				pw.flush();
				break;
			
			case 3:
				
				System.out.println("Thank you for your service!" + " " + "\nYour total change is: " + moneyFedBeforeChange);
				double moneyFedAfterChange = myVendingMachine.GiveChange(moneyFedBeforeChange);
				action = "Give Change: " + "$" + moneyFedBeforeChange + " " +  "$" + moneyFedAfterChange;
				moneyFedBeforeChange = 0;
				pw.println(dtf.format(now) + " " + action);
				pw.flush();
				subMenuRepetition = false;
				break;
				
			default: 
				
				System.out.println(subMenuUserChoice + " is not a valid option. Please Select Another.");
				break;
				}
			}
			break;
		
	
	case 3:
			System.out.println("Exiting Vendor");
			pw.flush();
			userInput.close();
			System.exit(0);
			break;
	
	default: 
			System.out.println(userChoice + " is not a valid option! Please Select Another!");
			break;

	
		}
	}
}
		
	catch (FileNotFoundException e) {
		
		System.out.println("Wrong file type!");
	}
	catch (InputMismatchException e) {
			
		System.out.println("Wrong input type");
			
	} 	
	catch (IOException e1) {
			
		e1.printStackTrace();
				}
			}
		}
	
