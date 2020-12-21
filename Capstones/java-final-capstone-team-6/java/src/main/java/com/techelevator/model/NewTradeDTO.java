package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

public class NewTradeDTO {
	private Long userFrom;
	private Long userTo;
	private Long comicId;
	private String tradeType;
	
	public Long getUserFrom() {
		return userFrom;
	}
	
	public void setUserFrom(Long userFrom) {
		this.userFrom = userFrom;
	}
	
	public Long getUserTo() {
		return userTo;
	}
	
	public void setUserTo(Long userTo) {
		this.userTo = userTo;
	}
	
	public Long getComicId() {
		return comicId;
	}
	
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	
	public String getTradeType() {
		return tradeType;
	}
	
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	
	@AssertTrue
	public boolean isValidTradeType() {
		return Trade.TRADE_TYPE_REQUEST.equals(this.tradeType) || Trade.TRADE_TYPE_SEND.equals(this.tradeType);
	}
	
}
