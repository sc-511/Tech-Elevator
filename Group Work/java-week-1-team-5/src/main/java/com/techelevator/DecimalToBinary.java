package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter in a series of deciamal values (separated by spaces): ");
		
		String userInput = keyboard.nextLine();
		
		String[] splitValues = userInput.split(" ");
		double binVal = 0;
		for (int i = 0; i < splitValues.length; i++) {
			
			double decVal = Double.parseDouble(splitValues[i]);
			for (; decVal > 0; decVal /= 2) {
				 binVal = (decVal % 2) + binVal;
			}
			
			
			
		
			System.out.println (decVal + " in binary is " + binVal);
		}
		
	}

}
				//  ????? dont understand how to keep the binary going 
