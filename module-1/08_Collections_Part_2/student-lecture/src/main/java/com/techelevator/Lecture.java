package com.techelevator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {
		
		
		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();
			
		
		
			//key 	//value							//key	//value
		Map <String, String> zipCodes = new HashMap <String, String> ();
		
		//HashMap is the fastest
		//LinkedHashMap preserves the insertion order
		//TreeMap sorts keys
		
		zipCodes.put("15222", "Downtown");
		zipCodes.put("15201", "Lawrenceville");
		zipCodes.put("15203", "SouthSide");
		zipCodes.put("15232", "ShadySide");
		zipCodes.put("90210", "Beverly Hills, that's where I want to be");
		
		System.out.println(zipCodes.get("15222"));
		
		Map <Integer, String> zipCodesInteger = new HashMap <Integer, String> ();
		
		zipCodesInteger.put(15222, "Downtown");
		zipCodesInteger.put(15201, "Lawrenceville");
		zipCodesInteger.put(15203, "SouthSide");
		zipCodesInteger.put(15232, "ShadySide");
		zipCodesInteger.put(90210, "Beverly Hills, that's where I want to be");
		
		for (Integer key : zipCodesInteger.keySet()) {
			
			System.out.print("Key : " + key);
			System.out.print("\tValue: " + zipCodesInteger.get(key));
			
			
			System.out.println("####################");
			System.out.println("        SETS");
			System.out.println("####################");
			System.out.println();
			
			Set <String> names = new HashSet <String> ();
			
			names.add("Tom");
			names.add("Beth");
			names.add("Walt");
			names.add("Ellen");
			names.add("Marissa");
			names.add("Jennifer");
			names.add("Jake");
			names.add("Eric");
			names.add("Tom");
			names.add("Justin");
			
			System.out.println("Set size is: " + names.size());
			
			for (String name : names) {
				
				System.out.println(name + " is an instructor at Tech Elevator Pittsburgh");
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(firstRepeatingCharacter("Elevate Yourself"));
	}
	
	public static String firstRepeatingCharacter(String input) {
		
		Set <String> seenThisLetter = new HashSet <String>();
		
		for (int i = 0; i < input.length(); i++) {
			
			String thisLetter = input.substring (i, i+1);
			
			if (seenThisLetter.contains(thisLetter)) {
				return thisLetter;
			}
			
				seenThisLetter.add(thisLetter);
			
			
//			int sizeBefore = seenThisLetter.size();
//			seenThisLetter.add(thisLetter);
//			int sizeAfter = seenThisLetter.size();
//			
//			if (sizeBefore == sizeAfter) {
//				return thisLetter;
//			}
		}
		
		return "";
	}

}
