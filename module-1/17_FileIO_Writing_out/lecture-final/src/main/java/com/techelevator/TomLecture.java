package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {
	
	
	
	public static void main(String[] args) {
		System.out.println("Calling method1()...");
		
		int answer = method1();
		
		System.out.println("Finished with method1()! Answer was: " + answer);
		
		
	}
	
	
	public static int method1() {
		
		int[] gonnaBreak = { 10, 20, 30 };

		int x = 1000;
		try {
			System.out.println("Inside the TRY");
			x = gonnaBreak[1];			
		} catch (Exception e) {
			System.out.println("Inside the CATCH");
			x = -1000;
		} 
		
		return x;		
		
	}
	
	
	
	public static void main_old(String[] args) {
		
		
		long before = System.currentTimeMillis();
		
		long answer = 0;
		
		for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
			System.out.println(i);
			answer++;
		}
		
		long after = System.currentTimeMillis();
		
		long elapsed = after - before;
		
		System.out.println(answer);
		System.out.println("Took " + elapsed + " milliseconds");
		
	}
	
	public static void main_copy_alice(String[] args) {
		File alice = new File("alice.txt");
		File output = new File("alice_copy.txt");

		long before = System.currentTimeMillis();
		try (PrintWriter pw = new PrintWriter(new FileWriter(output, true))) {
			
		
			try (Scanner incoming = new Scanner(alice)) {
				
				while(incoming.hasNextLine()) {
					String thisLine = incoming.nextLine();
					pw.println(thisLine);	
				}				
				
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		long after = System.currentTimeMillis();
		
		long elapsed = after - before;
		
		System.out.println("Took " + elapsed + " milliseconds");
	
	}
	
	
	
	
	public static void main3(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		File log = new File("log.txt");
		
		if(!log.exists()) {
			try {
				log.createNewFile();
			} catch(IOException e) {
				System.out.println("I handled an exception, but I'm keepin' on keepin' on");
			}
		}
		
		
		// try-with-resources
//		try (PrintWriter pw = new PrintWriter(log)) {                            // Create new file and print to it		
		try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {      // Open existing file and append to it

			boolean keepGoing = true;
			while(keepGoing) {
				System.out.println("Enter a message for the log file: >>> ");
				String message = keyboard.nextLine();
				
				if(message.equals("STOP")) {
					keepGoing = false;
				} else {
					pw.println(message);
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("PrintWriter Exception!");
		} catch (IOException ioe) {
			System.out.println("FileWriter Exception!");
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static void main2(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */


//		System.out.println("Enter a file name: >>>");
//		String fileName = userInput.nextLine();
//		
//		File f = new File(fileName);
//		
//		if(f.exists()) {
//			System.out.println("Name: " + f.getName());
//			System.out.println("Full path: " + f.getAbsolutePath());
//			
//			if(f.isDirectory()) {
//				System.out.println("Type: directory");
//			} else if(f.isFile()) {
//				System.out.println("Type: file");
//			}
//			
//			System.out.println("Size: " + f.length());
//			
//		} else {
//			System.out.println(f.getAbsolutePath() + " does not exist.");
//		}
		
		System.out.println("Let's create a directory!");
		System.out.println("Enter the path of a new directory: >>> ");
		String newDirectory = userInput.nextLine();
		
		File f = new File(newDirectory);
		
		if(f.exists()) {
			System.out.println("This path already exists!");
		} else {
			
			if(f.mkdir()) {
				System.out.println("Directory successfully created!");
			} else {
				System.out.println("Could not create directory :( ");
			}
			
		}
		
	
		System.out.println("Let's create a file in said directory!");
		System.out.println("Enter the file name: >>> ");
		String newFile = userInput.nextLine();
		
		File fileToCreate = new File(newDirectory, newFile);
		
		if(fileToCreate.createNewFile()) {
			System.out.println("Created file successfully!");
			System.out.println("Name: " + fileToCreate.getName());
			System.out.println("Path: " + fileToCreate.getAbsolutePath());
			System.out.println("Size: " + fileToCreate.length());
		
		
			System.out.println("Let's put some data into that file!");
			System.out.println("Put a message into the new file: >>> ");
			String message = userInput.nextLine();
						
			PrintWriter pw = new PrintWriter(fileToCreate);
			pw.println(message);
			pw.flush();

			System.out.println("Size: " + fileToCreate.length());
			
			
		} else {
			System.out.println("Couldn't create new file! :( ");
		}
		
		
	}
}
