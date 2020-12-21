package com.techelevator.model;

import java.security.Principal;

import com.techelevator.dao.UserDAO;

public class ComicAuthorization {

	private Principal principal;
	private Comic comic;
	private UserDAO userDAO;
	private User user;
	
	public ComicAuthorization(Principal principal, Comic comic) {
		this.principal = principal;
		this.comic = comic;
	}
	
	public boolean isAllowedToCreate() {
		boolean isAllowed = false;
			isAllowed = getCurrentUserId(principal).equals(userId());
		return isAllowed;
	}
	
	public String principalUsername() {
		return principal.getName();
	}
	
	public Long userId() {
		return user.getId();
	}
	private Long getCurrentUserId(Principal principal) {
        return userDAO.findByUsername(principal.getName()).getId();
    }
}
