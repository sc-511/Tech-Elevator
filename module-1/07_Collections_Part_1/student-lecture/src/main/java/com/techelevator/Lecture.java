package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List <String> names; // names: null
		
		names = new ArrayList <String> (); // names -> new ArrayList of Strings on the heap
		
		// List <String> names = new ArrayList <String> (); --> same output
		
		// String [] namesArr = new String [0]; --> once instantiated cant be changed so this is unhelpful;
		
		names.add("Tom M");
		names.add("Tom A");
		names.add("Walt");
		names.add("Beth");
		
		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		
		for (int i =0; i < names.size(); i++) {
			System.out.println("Index " + i + ":\t");
			System.out.println(names.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		
		System.out.println("Adding Tom M again, because he loves himself");
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println("Index " + i + ":\t");
			System.out.println( names.get(i) );
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");
		
		//names.add(3, "Jennifer");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//names.remove(5);
		

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		
		boolean containsBeth;
		containsBeth = names.contains("Beth");
		
		System.out.print("name does ");
		if (!containsBeth) {
			System.out.println("not ");
		}
		System.out.println("contain Beth!");
		
		
		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfWalt = names.indexOf("Walt");
		System.out.println("Walt is at position #: " + indexOfWalt);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");
		//List <String> names; // names: null
		
		//names = new ArrayList <String> ();

		String [] namesAsArray = names.toArray(new String [names.size()]);
		
		System.out.println("Here is my array:\n========");
		
		for (int i = 0; i < namesAsArray.length; i++) {
			
			System.out.println(namesAsArray[i]);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(names);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");
		
		Collections.reverse(names);

		
		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");
		
		
		
		Integer x = new Integer(5);
		x++;
		
		// Auto boxing and Auto unboxing
		
		Character c = new Character ('c');
		Double pi = new Double (3.14159);
		Boolean t = new Boolean (true);
		Float f = new Float(0.9f);
		
		Double.parseDouble("3.14"); // 3.14
		Integer.parseInt("6"); // 6
		
		List <Integer> scores = new ArrayList <Integer>();

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String  name  : names) {
			System.out.println(name);
		}
		
		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		
		

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////
		// First In / First Out
		// FIFO
		
		Queue <String> tasks  = new LinkedList <String>();
		// Add: Offer
		// Remove: Poll
		
		tasks.offer("Run the dishwasher");
		tasks.offer("Sweep the floor");
		tasks.offer("Scrub the toilet");
		
		System.out.println(tasks.size());
		String nextTask = tasks.poll();
		System.out.println(nextTask);
		
		while(tasks.size() > 0) {            // while (!tasks.isEmpty())
			
			System.out.println(tasks.size());
			System.out.println(tasks.poll());
		}
		
		
		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();
		// Last in Last out
		// LIFO 
		
		Stack <String> websites = new Stack <String> ();
		

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////
		websites.push("www.google.com");
		websites.push ("en.wikipedia.org");
		websites.push("www.techelevator.com");
		
		while( !websites.isEmpty()) {
			
		System.out.println(websites.size());
		System.out.println(websites.pop());
		System.out.println(websites.size());
		
		}
		
		////////////////////
		// POPPING THE STACK
		////////////////////

	}
}
