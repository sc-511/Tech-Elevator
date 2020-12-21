package com.techelevator.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

public class FriendsListStatusUpdateDTO {
	
	@NotEmpty
	private String friendListRequestStatus;

	public String getFriendListRequestStatus() {
		return friendListRequestStatus;
	}

	public void setFriendListRequestStatus(String friendListRequestStatus) {
		this.friendListRequestStatus = friendListRequestStatus;
	}
	
	@AssertTrue
	public boolean isValidStatus() {
		return FriendsList.FRIEND_LIST_REQUEST_STATUS_APPROVED.equals(friendListRequestStatus) || FriendsList.FRIEND_LIST_REQUEST_STATUS_REJECTED.equals(friendListRequestStatus);
	}

}
