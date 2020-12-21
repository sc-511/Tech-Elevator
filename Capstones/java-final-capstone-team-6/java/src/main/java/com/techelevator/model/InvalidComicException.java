package com.techelevator.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidComicException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public InvalidComicException(String message) {
		super(message);
	}
}
