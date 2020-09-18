package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Please enter the length: ");
		
		String lengthValStr = keyboard.nextLine();
		
		int lengthVal = Integer.parseInt(lengthValStr);
		
		System.out.println("Is the measurement in (m)eter, or (f)eet? ");
		
		String mOrF = keyboard.nextLine();
		
		if (mOrF.equals("m")) {
			
			double valF = lengthVal * 3.2808399;
			
			System.out.println(lengthVal + "m" + " is " + valF + "f");
		}
		
		else {
			
			double valM = lengthVal * 0.3048;
			
			System.out.println(lengthVal + "f" + " is " + valM + "m");
		}
		
	}

}
