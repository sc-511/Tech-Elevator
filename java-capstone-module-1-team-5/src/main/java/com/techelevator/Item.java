package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Item implements Soundable {
	
	private String name;
	private double price;
	private String type;
	private String sound;
	private int quantity;
	
	
	public Item (String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity = 5;
	}
	

	public double getPrice() {
		return price;
	}
	
	public String type() {
		return type;
	}
	
	@Override
	public String getSound() {
		if (type.toLowerCase() == "chip") {
			sound = "Crunch Crunch, Yum!";
		} else if (type.toLowerCase() == "candy") {
			sound = "Munch Munch, Yum";
		} else if (type.toLowerCase() == "drink") {
			sound = "Glug Glug, Yum!";
		} else if (type.toLowerCase() == "gum") {
			sound = "Chew Chew, Yum!";
		} else {
			sound = "Unknown sound, but still Yum!";
		}
		return sound;
	}

	public int getQuantity() {
		return quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
