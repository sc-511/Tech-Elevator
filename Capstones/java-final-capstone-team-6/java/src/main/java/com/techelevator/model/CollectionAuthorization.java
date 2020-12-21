package com.techelevator.model;

import java.security.Principal;

public class CollectionAuthorization {
	private Principal principal;
	private Collection collection;
	
	public CollectionAuthorization(Principal principal, Collection collection) {
		this.principal = principal;
		this.collection = collection;
	}
	
	public boolean isAllowedToCreate() {
		boolean isAllowed = false;
		//if(collection.isRequestType)
		return isAllowed;
	}
	
	public String principalUsername() {
		return principal.getName();
	}
}
