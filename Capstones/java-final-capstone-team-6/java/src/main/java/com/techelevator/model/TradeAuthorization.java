package com.techelevator.model;

import java.security.Principal;


public class TradeAuthorization {
	
	private Principal principal;
	private Trade trade;

	public TradeAuthorization(Principal principal, Trade trade) {
		this.principal = principal;
		this.trade = trade;
	}
	
	public boolean isAllowedToView() {
		return principalUsername().equals(fromUsername()) ||
				principalUsername().equals(toUsername());
	}
	
	public boolean isAllowedToCreate() {
		boolean isAllowed = false;
		if(trade.isRequestType()) {
			isAllowed = principalUsername().equals(toUsername());
		} else if(trade.isSendType()) {
			isAllowed = principalUsername().equals(fromUsername());
		}
		return isAllowed;
	}
	
	public boolean isAllowedToApproveOrReject() {
		return principalUsername().equals(fromUsername());
	}

	private String toUsername() {
		return trade.getUserTo().getUsername();
	}

	private String fromUsername() {
		return trade.getUserFrom().getUsername();
	}

	private String principalUsername() {
		return principal.getName();
	} 
	
}
