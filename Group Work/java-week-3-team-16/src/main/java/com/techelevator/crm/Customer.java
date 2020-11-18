package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.Billable;
import com.techelevator.Person;

public class Customer extends Person implements Billable{
	
	private String phoneNumber;
	private List<Pet> pets = new ArrayList <> ();
	
	public Customer (String firstName, String lastName, String phoneNumber) {
		
		super(firstName, lastName);
		this.phoneNumber = phoneNumber;
	}
	
	public Customer (String firstName, String lastName) {
		
		super(firstName, lastName);
		this.phoneNumber = "";
		
	}
	
	public Customer () {}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Pet> getPets() {
		return pets;
	}
	
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public double getBalanceDue(Map<String, Double> servicesRendered) {
		
		double totalServices = 0;
			for (String service : servicesRendered.keySet()) {
				totalServices += servicesRendered.get(service);
			
		}
		return totalServices;
	}
	
}
