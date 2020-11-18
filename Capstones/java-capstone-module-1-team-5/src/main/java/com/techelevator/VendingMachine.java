package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
	private String menuDisplay = "(1) Display Vending Machine Items";
	private String menuPurchase = "(2) Purchase";
	private String menuExit = "(3) Exit";
	private double feedOneDollar = 1;
	private double feedTwoDollars = 2;
	private double feedFiveDollars = 5;
	private double feedTenDollars = 10;
	private String feedMoney = "(1) Feed Money ";
	private String selectItem = "(2) Select Product";
	private String finishTransaction = "(3) Finish Transaction";
	private double totalFeedCount = 0;
	private double numQuarters = 0;
	private double numDimes = 0;
	private double numNickels = 0;
	private Inventory inventory = new Inventory();
	private Map<String,String> slotName = inventory.getSlotNameMap();
	private Map<String,Double> slotPrice = inventory.getSlotPriceMap();
	private Map<String,String> slotType = inventory.getSlotTypeMap();
	private Map<String,Integer> slotQuantity = inventory.getSlotQuantityMap();
	private List<String> slotList = inventory.getSlotList();
	
	public VendingMachine () {
		
	}
	
	public double getNumQuarters() {
		return numQuarters;
	}
	public double getNumDimes() {
		return numDimes;
	}
	public double getNumNickels() {
		return numNickels;
	}
	
	public double getTotalFeedCount() {
		return totalFeedCount;
	}
	public String getMenuDisplay() {
		return menuDisplay ;
	}

	public String getMenuPurchase() {
		return menuPurchase;
	}

	public String getMenuExit() {
		return menuExit;
	}

	public String getFeedMoney() {
		return feedMoney;
	}

	public String getSelectItem() {
		return selectItem;
	}

	public String getFinishTransaction() {
		return finishTransaction;
	}

	public double getFeedOneDollar() {
		return feedOneDollar;
	}

	public double getFeedTwoDollars() {
		return feedTwoDollars;
	}

	public double getFeedFiveDollars() {
		return feedFiveDollars;
	}

	public double getFeedTenDollars() {
		return feedTenDollars;
	}
	

	public double GiveChange(double conversion){
		
		totalFeedCount = conversion;

		while (totalFeedCount > 0.04) {
			
			
			if (totalFeedCount >= 0.25) {
		
				totalFeedCount -= 0.25;
		
				numQuarters ++;
		
	}
	
			else if (totalFeedCount >= 0.10) {
		
				totalFeedCount -= 0.10;
		
				numDimes ++;
	}
	
			else {
		
				totalFeedCount -= 0.05;
		
				numNickels ++;
	}
	
		
		}
		
		System.out.println("Your change is " + numQuarters + " quarters and " + numDimes + " dimes and " + numNickels + " nickels. ");
		totalFeedCount = 0;
		numQuarters = 0;
		numDimes = 0;
		numNickels = 0;
		return totalFeedCount;
	}

	public double feedMoney (double moneyFed) {
		 
		if (moneyFed == getFeedOneDollar() || moneyFed == getFeedTwoDollars()|| moneyFed == getFeedFiveDollars()|| moneyFed == getFeedTenDollars() ) {
			totalFeedCount += moneyFed;
		}
		
		else {
			totalFeedCount = 0;
			 System.out.println(moneyFed + " is a invalid entry. Please utilize a 1, 2, 5, or 10.");
			 
		}
		return totalFeedCount;
	}
	
	public double deductBalance(double productPrice) {
		return totalFeedCount -= productPrice;
	}
	
	public void displayItems(){

		
		System.out.println("Vending Maching Items");
		System.out.println("Slot - Item Name - Price - Remaining Quantity");
		System.out.println("----   ---------   -----   ------------------");
			for(String slot : slotList) {
				
				if(slotQuantity.get(slot) == 0) {
					System.out.println(slot + " - " + slotName.get(slot) + " - $" + slotPrice.get(slot) + 
							" - SOLD OUT");
				} else {
					System.out.println(slot + " - " + slotName.get(slot) + " - $" + slotPrice.get(slot) + 
							" (" + slotQuantity.get(slot) + " remaining)");
				}
			}
			
		System.out.println("--------------------------");
		
	}
	
	public String getItem(String slotLocation) {
		
		if (slotName.get(slotLocation) == null) {
			return null;
		}
			return slotName.get(slotLocation);

	}
	
	public double getItemPrice(String slotLocation) {
		
		if (slotPrice.get(slotLocation) == null) {
			return -1;
		}
		return slotPrice.get(slotLocation);
		
	}
	
	public String getItemType(String slotLocation) {
		
		return slotType.get(slotLocation);
	}
	
	public int getItemQuantity(String slotLocation) {
		
		return slotQuantity.get(slotLocation);
	}
	
	public int deductItemQuantity(String slotLocation) {
		int currentQuantity = slotQuantity.get(slotLocation);
		int deductedQuantity = currentQuantity - 1;
		slotQuantity.replace(slotLocation, deductedQuantity);
		return slotQuantity.get(slotLocation);
	}
	
	public String getSound(String slotLocation) {
		String sound;
		
		if (slotType.get(slotLocation).toLowerCase().equals("chip")) {
			sound = "Crunch Crunch, Yum!";
		} else if (slotType.get(slotLocation).toLowerCase().equals("candy")) {
			sound = "Munch Munch, Yum";
		} else if (slotType.get(slotLocation).toLowerCase().equals("drink")) {
			sound = "Glug Glug, Yum!";
		} else if (slotType.get(slotLocation).toLowerCase().equals("gum")) {
			sound = "Chew Chew, Yum!";
		} else {
			sound = "Unknown sound, but still Yum!";
		}
		return sound;
	}

}


	

