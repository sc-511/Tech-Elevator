package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the amount of the bill: ");
		
		double amountBill = keyboard.nextDouble();
		
		
		System.out.print("Please enter the amount tendered: ");
		
		double amountTendered = keyboard.nextDouble();
		
		System.out.print("The change required is " + (amountTendered - amountBill));
	}

}
