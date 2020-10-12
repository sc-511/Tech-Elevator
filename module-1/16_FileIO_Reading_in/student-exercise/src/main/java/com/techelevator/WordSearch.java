package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		
	
		System.out.println("What is the file that should be searched?");
		
		File inputFile = getInputFileFromUser();
		
		System.out.println("What is the search word you are looking for?");
		
		Scanner keyboard = new Scanner (System.in);
		
		String wordSearch = keyboard.nextLine();
		
		System.out.println("Should the search be case sensitive?" + " (Y/N)");
		
		String caseSensitive = keyboard.nextLine();
		
		int sentenceLine = 0;
		
		if (caseSensitive.equalsIgnoreCase("y")) {
			
			try(Scanner fileScanner = new Scanner(inputFile)){
				
				while(fileScanner.hasNextLine()) {
					
					sentenceLine++;
					
					String wordSentence = fileScanner.nextLine();
					
					if (wordSentence.contains(" " + wordSearch + " ")) {
					
					System.out.println("(" + sentenceLine + ")" + " " + wordSentence);
					}
				}
			}
			
			catch(InputMismatchException e) {
				System.out.println("Wrong input! Please follow input directions!");
			}
			
			catch(FileNotFoundException e) {
				System.out.println("File was not found!!!");
			}
		}
		
		if(caseSensitive.equalsIgnoreCase("n")){

			try(Scanner fileScanner = new Scanner(inputFile)) {
			
				while(fileScanner.hasNextLine()) {
					
					sentenceLine++;
					
					String wordSearchCap = wordSearch.substring(0,1).toUpperCase() + wordSearch.substring(1);
				
					String wordSentence = fileScanner.nextLine();
					
					
					if (wordSentence.contains((" " + wordSearch+ " "))) {
					
					System.out.println("(" + sentenceLine + ")" + " " + wordSentence);
					
					}
					
					if (wordSentence.contains((" " + wordSearchCap + " "))) {
						
					System.out.println("(" + sentenceLine + ")" + " " + wordSentence);
					
					}
					
					
				}
			
			}
		
			catch(InputMismatchException e) {
				System.out.println("Wrong input! Please follow input directions!");
			}
		
			catch(FileNotFoundException e) {
				System.out.println("File was not found!!!");
			}
		
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
