package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

	private String name;
	private String address;
	private String phoneNumber;
	private List <Accountable> accounts = new ArrayList <Accountable> ();
	
	public BankCustomer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Accountable [] getAccounts() {
		
		Accountable [] accountsArray = new Accountable [accounts.size()];
		
		for (int i =0; i < accounts.size(); i++) {
			
			accountsArray[i] = accounts.get(i);
			
			}
		
		return accountsArray;
	}
	
	public void addAccount(Accountable newAccount) {
		
		accounts.add(newAccount);
	}
	
	public boolean isVip() {
		
		//saving.balance + checking - debt	>= 25k
		
		int totalAccountBalance = 0;
		
		for (Accountable account : getAccounts()) {
			
			totalAccountBalance += account.getBalance();
		}
		
			if (totalAccountBalance >= 25000) {
				return true;
			}
			
			else {
				
				return false;
			}
	}

}
