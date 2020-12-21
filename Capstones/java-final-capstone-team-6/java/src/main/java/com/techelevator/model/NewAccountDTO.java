package com.techelevator.model;

public class NewAccountDTO {
	private Long accountId;
	private Long userId;
	private Long comicId;
	private Long comicConditionId;
	private Long comicTradableStatusId;
	private Long collectionId;
	private Long accountTypeId;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public Long getComicConditionId() {
		return comicConditionId;
	}
	public void setComicConditionId(Long comicConditionId) {
		this.comicConditionId = comicConditionId;
	}
	public Long getComicTradableStatusId() {
		return comicTradableStatusId;
	}
	public void setComicTradableStatusId(Long comicTradableStatusId) {
		this.comicTradableStatusId = comicTradableStatusId;
	}
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	public Long getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	
}
