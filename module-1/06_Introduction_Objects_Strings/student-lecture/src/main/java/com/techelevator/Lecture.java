package com.techelevator;

import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

//		System.out.println("Enter [F] for Fahrenheit or [C] for Celcius");
//		
//		Scanner keyboard = new Scanner(System.in);
//		
//		String userTyped = keyboard.nextLine();
//		if (userTyped.equalsIgnoreCase("F")) {
//			System.out.println("Fahrenheit");
//		}
//		else if (userTyped.equalsIgnoreCase("C")) {
//			System.out.println("Celcius");
//		}
//		else {
//			System.out.println("I dunno");
//		}
		
		
		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		
		String literal = "This is an example of a literal";
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		System.out.println(literal.endsWith("hat"));
		System.out.println(literal.indexOf("is"));
		System.out.println(literal.indexOf("is", 3));
		System.out.println(literal.lastIndexOf("is"));
		
		System.out.println(literal.substring(4));
		System.out.println(literal.substring(5));
		System.out.println(literal.substring(5, 10));
		System.out.println("             .trim() will remove whitespace at the beginning and at the end               " .trim());
		// will remove whitespace at the beginning and at the end but not the middle
		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		
		/*  IN-CLASS EXAMPLE 
		 * String[] pieces = "Tom Medvitz, Esquire".split(" ");
		 * for (int i = 0; i < pieces.length; i++){
		 * 	pieces[i] = pieces [i].toUpperCase();
		 * 	System.out.println(pieces[i]);
		 */
		
		String hello1 = "Hello!";
		String hello2 = "Hello!";
		
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
