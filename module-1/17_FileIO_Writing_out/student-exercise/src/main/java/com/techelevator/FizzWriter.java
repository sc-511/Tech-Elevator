package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		
		
		File output = new File("FizzWriter.txt");
		
		try(PrintWriter pw = new PrintWriter(output)) {
			
			for (int i = 1; i <= 300; i++) {
				
				if (i % 3 == 0 && i % 5 == 0) {
					
					pw.println("FizzBuzz");
				}
				
				else if (i % 5 == 0 || Integer.toString(i).contains("5")) {
					
					pw.println("Buzz");
				}
				
				else if (i % 3 == 0 || Integer.toString(i).contains("3")) {
					
					pw.println("Fizz");
				}
				
				else {
					
					pw.println(i);
				}
				
			
				
			}			
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		
		}
	}
}
		
		


			
			
			
		
