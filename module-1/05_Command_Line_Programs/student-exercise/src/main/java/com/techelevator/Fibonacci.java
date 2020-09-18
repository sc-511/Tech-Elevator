package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
	Scanner keyboard = new Scanner (System.in);	
	
	System.out.println("Please enter the Fibonnaci number: ");
	
	int numFib = keyboard.nextInt();
	
	if(numFib > 1) {
		
        System.out.print("0 1 1 ");
        
        int fibTwo = 1;
        
        int fibValue = 1;
        
        for(int i = 1; i + fibTwo < numFib;){
        	
            fibValue = i + fibTwo;
            
            i = fibTwo;
            
            fibTwo = fibValue;
            
            System.out.print(fibValue + " ");
        }
    } 
	else {
    	
        System.out.println("Enter a value higher than 1");
    }
	
	}
}

