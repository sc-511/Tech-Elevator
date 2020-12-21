package com.techelevator.model;

import java.util.Objects;


public class Account {
	private Long accountId;
	private Long userId;
	private Long comicId;
	private Long comicConditionId;
	private Long comicTradableStatusId;
	private Long collectionId;
	private Long accountTypeId;
	
	public static final Long STANDARD_USER_ACCOUNT = 1L;
	public static final Long PREMIUM_USER_ACCOUNT = 2L;
	
	public Account (Long accountId, Long userId, Long comicId, Long comicConditionId, Long comicTradableStatusId, Long collectionId, Long accountTypeId) {
		this.accountId = accountId;
		this.userId = userId;
		this.comicId = comicId;
		this.comicConditionId = comicConditionId;
		this.comicTradableStatusId = comicTradableStatusId;
		this.collectionId = collectionId;
		this.accountTypeId = accountTypeId;
	}
	public Account () {}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public Long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountType(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public Long getCollectionId() {
		return collectionId;
	}
	public Long getComicConditionId() {
		return comicConditionId;
	}
	public Long getComicTradableStatusId() {
		return comicTradableStatusId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setComicConditionId(Long comicConditionId) {
		this.comicConditionId = comicConditionId;
	}
	public void setComicTradableStatusId(Long comicTradableStatusId) {
		this.comicTradableStatusId = comicTradableStatusId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	
	public boolean isStandard() {
		   return STANDARD_USER_ACCOUNT.equals(this.accountTypeId);
	   }
	   
	public boolean isPremium() {
		   return PREMIUM_USER_ACCOUNT.equals(this.accountTypeId);
	   }
	
	public void trade(Account accountTo, Long comicToTrade) {
		if(this.comicId.compareTo(comicToTrade) == 0) {
			this.comicId = 0L;
    		accountTo.comicId = comicToTrade;
    	} else {
    		throw new InvalidComicException(comicToTrade+" could not be found!");
    	}
		
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                userId == account.userId &&
                comicId.equals(account.comicId)&&
                comicConditionId.equals(account.comicConditionId)&&
                comicTradableStatusId.equals(account.comicTradableStatusId)&&
                collectionId.equals(account.collectionId)&&
                accountTypeId.equals(account.accountTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, comicId, comicConditionId, comicTradableStatusId, collectionId, accountTypeId);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", comicId=" + comicId +
                ", comicConditionId=" + comicConditionId +
                ", comicTradableStatusId=" + comicTradableStatusId +
                ", collectionId=" + collectionId +
                ", accountTypeId=" + accountTypeId +
                '}';
    }
	
	
	
}
