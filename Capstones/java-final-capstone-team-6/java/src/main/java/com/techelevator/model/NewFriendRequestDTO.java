package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

public class NewFriendRequestDTO {

	private Long userFrom;
	private Long userTo;
	private String friendListRequestType;
	
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
	
	public String getFriendListRequestType() {
		return friendListRequestType;
	}
	
	public void setFriendListRequestType(String friendListRequestType) {
		this.friendListRequestType = friendListRequestType;
	}

	@AssertTrue
	public boolean isValidFriendListRequestType() {
		return FriendsList.FRIEND_LIST_REQUEST_TYPE_REQUEST.equals(this.friendListRequestType) || FriendsList.FRIEND_LIST_REQUEST_TYPE_SEND.equals(this.friendListRequestType);
	}
	
	
	
}
