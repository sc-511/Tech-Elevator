package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Please enter the temp: ");
		
		String tempValStr = keyboard.nextLine();
		
		int tempVal = Integer.parseInt(tempValStr);
		
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		
		String cOrF = keyboard.nextLine();
		
		if (cOrF.equals("c")) {
			
			double valF = tempVal * 1.8 + 32;
			
			System.out.println(tempVal + "C" + " is " + valF + "f");
		}
		else {
			
			double valC = (tempVal - 32) / 1.8;
			
			System.out.println(tempVal + "F" + " is " + valC + "C");
		}
	}

}
