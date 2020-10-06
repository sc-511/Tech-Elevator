package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		
		
		
		System.out.println("Where is the quiz file? ");
	
		File inputFile = getInputFileFromUser();
		
		
		
		int totalAnswersCorrect = 0;
		
		try (Scanner fileScanner = new Scanner(inputFile)){
			
			while(fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				
				Scanner scanner = new Scanner (line).useDelimiter("|");
				
				
				System.out.println("\n" + line + scanner.next());
				
				String userAnswer = keyboard.nextLine();
				
				
				
				if (userAnswer.equalsIgnoreCase("blue") || userAnswer.equalsIgnoreCase("mop")) {
					
					totalAnswersCorrect ++;
					
					System.out.println("\nYour answer: " + userAnswer);
					
					System.out.println("\nCorrect!");
				}
				
				else {
				
					System.out.println("\nYour answer: " + userAnswer);
				
					System.out.println("\nSorry that isn't correct!");
				
				}
			}
			
			System.out.println("\nYou got " + totalAnswersCorrect + " answer(s) correct out of the total 2 questions asked.");
			
		}
		
		catch (FileNotFoundException e) {
			
		}
		
		
		
		
		
		
		
	}
		
	private static File getInputFileFromUser() {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter path to input file >>> ");
		
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		
		if(inputFile.exists() == false) { // checks for the existence of a file
			
			System.out.println(path+" does not exist");
			
			System.exit(1);
			// Ends the program
		} else if(inputFile.isFile() == false) {
			
			System.out.println(path+" is not a file");
			
			System.exit(1); // Ends the program
		}
		return inputFile;
	}

}
