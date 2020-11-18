package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
	
	private HashMap<String, String> slotNameMap = new HashMap<String, String>();
	private HashMap<String, Double> slotPriceMap = new HashMap<String, Double>();
	private HashMap<String, String> slotTypeMap = new HashMap<String, String>();
	private HashMap<String, Integer> slotQuantityMap = new HashMap<String, Integer>();
	private List<String> slotList = new ArrayList<>();
	private int quantity = 5;
	
	public Inventory() {
		restockItems();
	}
	
	public void restockItems(){
		
		File inventoryFile = new File("vendingmachine.csv");
		
		try (Scanner fileScanner = new Scanner (inventoryFile)){
			
			while (fileScanner.hasNextLine()) {
				
				String line = fileScanner.nextLine();
				String[] itemValues = line.split("\\|");
				
				slotNameMap.put(itemValues[0], itemValues[1]);
				slotPriceMap.put(itemValues[0], Double.parseDouble(itemValues[2]));
				slotTypeMap.put(itemValues[0], itemValues[3]);
				slotQuantityMap.put(itemValues[0], quantity);
				slotList.add(itemValues[0]);
				
			}
		}
			
		catch (FileNotFoundException e) {
			System.out.println("Inventory file not found.");
		}
	}
	
	public Map<String, String> getSlotNameMap(){
		return slotNameMap;
	}
	
	public Map<String, Double> getSlotPriceMap(){
		return slotPriceMap;
	}
	
	public Map<String, String> getSlotTypeMap(){
		return slotTypeMap;
	}
	
	public Map<String, Integer> getSlotQuantityMap(){
		return slotQuantityMap;
	}
	
	public List<String> getSlotList(){
		return slotList;
	}
	
	
}