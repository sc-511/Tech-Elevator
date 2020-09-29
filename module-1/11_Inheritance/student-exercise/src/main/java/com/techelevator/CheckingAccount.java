package com.techelevator;
import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(String accountHolderName, String accountNumber) {
		
		super(accountHolderName, accountNumber);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		
		super(accountHolderName, accountNumber, balance);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int withdraw (int amountToWithdraw) {
		
		if (super.getBalance() - amountToWithdraw > -100) {
			
			super.withdraw(amountToWithdraw);
			
			if (super.getBalance() < 0){
				
				super.withdraw(10);
			}
		}
		
		
		return super.getBalance();
		
		
		
		

	}

	
}
