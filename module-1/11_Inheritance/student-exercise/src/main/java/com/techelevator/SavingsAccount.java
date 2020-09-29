package com.techelevator;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int withdraw (int amountToWithdraw) {
		
		if (super.getBalance() - amountToWithdraw > 0) {
			
		
			if (super.getBalance() - amountToWithdraw < 150 ) {
			
			//System.out.println(super.withdraw(amountToWithdraw + 2));
				return super.withdraw(amountToWithdraw + 2);
		}
		
			return super.withdraw(amountToWithdraw);
		
		}
		
		
		
		return super.getBalance();
		
		
	}
		
	
	
}
