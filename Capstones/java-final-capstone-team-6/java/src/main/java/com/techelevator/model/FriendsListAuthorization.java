package com.techelevator.model;

import java.security.Principal;

public class FriendsListAuthorization {

	private Principal principal;
	private FriendsList friendsList;

	public FriendsListAuthorization(Principal principal, FriendsList friendsList) {
		this.principal = principal;
		this.friendsList = friendsList;
	}
	
//	public boolean isAllowedToView() {
//		return principalUsername().equals(fromUsername()) ||
//				principalUsername().equals(toUsername());
//	}
//	
//	public boolean isAllowedToCreate() {
//		boolean isAllowed = false;
//		if(friendsList.isRequestType()) {
//			isAllowed = principalUsername().equals(toUsername());
//		} else if(friendsList.isSendType()) {
//			isAllowed = principalUsername().equals(fromUsername());
//		}
//		return isAllowed;
//	}
//	
//	public boolean isAllowedToDelete() {
//		return principalUsername().equals(fromUsername());
//		
//	}
//	
//	public boolean isAllowedToApproveOrReject() {
//		return principalUsername().equals(fromUsername());
//	}

//	private String toUsername() {
//		return friendsList.getUserTo().getUsername();
//	}
//
//	private String fromUsername() {
//		return friendsList.getUserFrom().getUsername();
//	}

	private String principalUsername() {
		return principal.getName();
	}
	
}
