package com.techelevator.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

public class TradeStatusUpdateDTO {
	@NotEmpty
	private String tradeStatus;

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	@AssertTrue
	public boolean isValidStatus() {
		return Trade.TRADE_STATUS_APPROVED.equals(tradeStatus) || Trade.TRADE_STATUS_REJECTED.equals(tradeStatus);
	}
}
