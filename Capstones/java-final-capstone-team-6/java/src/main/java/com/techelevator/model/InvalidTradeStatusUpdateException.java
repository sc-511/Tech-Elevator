package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidTradeStatusUpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTradeStatusUpdateException(String oldStatus, String newStatus) {
		super("Cannot change tradeStatus from " + oldStatus+" to "+newStatus);
	}
	

}