package com.techelevator.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

public class AccountTypeDTO {
	@NotEmpty
	private String accountType;
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@AssertTrue
	public boolean isValidAccountType() {
		return Account.STANDARD_USER_ACCOUNT.equals(accountType) || Account.PREMIUM_USER_ACCOUNT.equals(accountType);
	}
}
