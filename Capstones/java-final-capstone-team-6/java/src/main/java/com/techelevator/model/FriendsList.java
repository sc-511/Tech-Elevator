package com.techelevator.model;

import java.util.Objects;

public class FriendsList {
	private Long requestId;
	private Long userFrom;
	private Long userTo;
	private String friendListRequestStatus;
	private String friendListRequestType;
	
	public static final String FRIEND_LIST_REQUEST_TYPE_REQUEST = "Request";
    public static final String FRIEND_LIST_REQUEST_TYPE_SEND = "Send";
    public static final String FRIEND_LIST_REQUEST_STATUS_PENDING = "Pending";
    public static final String FRIEND_LIST_REQUEST_STATUS_APPROVED = "Approved";
    public static final String FRIEND_LIST_REQUEST_STATUS_REJECTED = "Rejected";
	
    public FriendsList(String friendListRequestType, Long userFrom, Long userTo) {
    	this(null, friendListRequestType, getInitialStatusForFriendsListRequestType(friendListRequestType), userFrom, userTo);
    }
    	
    public FriendsList(Long requestId, String friendListRequestStatus, String friendListRequestType, Long userFrom, Long userTo) {
		this.requestId = requestId;
		this.friendListRequestType = friendListRequestType;
		this.friendListRequestStatus = friendListRequestStatus;
		this.userFrom = userFrom;
		this.userTo = userTo;
	}
	public FriendsList() {}
	public Long getRequestId() {
		return requestId;
	}
	
	public Long getUserFrom() {
		return userFrom;
	}
	
	public Long getUserTo() {
		return userTo;
	}
	
	public String getRequestStatus() {
		return friendListRequestType;
	}
	
	public String getRequestType() {
		return friendListRequestStatus;
	}
	
	public boolean isApproved() {
		return FRIEND_LIST_REQUEST_STATUS_APPROVED.equals(this.friendListRequestStatus);
	}
	
	public boolean isRejected() {
		return FRIEND_LIST_REQUEST_STATUS_REJECTED.equals(this.friendListRequestStatus);
	}
	
	public boolean isPending() {
		return FRIEND_LIST_REQUEST_STATUS_PENDING.equals(this.friendListRequestType);
	}
	
	public boolean isRequestType() {
		return FRIEND_LIST_REQUEST_TYPE_REQUEST.equals(this.friendListRequestType);
	}
	
	public boolean isSendType() {
		return FRIEND_LIST_REQUEST_TYPE_SEND.equals(this.friendListRequestType);
	}

	public void approve() throws InvalidTradeStatusUpdateException {
		if(isPending()) {
			// only pending transfers can be approved
			friendListRequestStatus = FRIEND_LIST_REQUEST_STATUS_APPROVED;
		} else {
			throw new InvalidTradeStatusUpdateException(friendListRequestStatus, FRIEND_LIST_REQUEST_STATUS_APPROVED);
		}
	}

	public void reject() {
		if(isPending()) {
			// only pending transfers can be rejected
			friendListRequestStatus = FRIEND_LIST_REQUEST_STATUS_REJECTED;
		} else {
			throw new InvalidTradeStatusUpdateException(friendListRequestStatus, FRIEND_LIST_REQUEST_STATUS_REJECTED);
		}
	}

    private void validateFriendsListRequestType() {
    	if(!(FRIEND_LIST_REQUEST_TYPE_REQUEST.equals(friendListRequestType) || FRIEND_LIST_REQUEST_TYPE_SEND.equals(friendListRequestType))) {
    		throw new IllegalArgumentException(friendListRequestType + " is not a valid transferType");
    	}
    }

    private void validateFriendsListRequestStatus() {
    	if(!(FRIEND_LIST_REQUEST_STATUS_APPROVED.equals(friendListRequestStatus) || FRIEND_LIST_REQUEST_STATUS_PENDING.equals(friendListRequestStatus) || FRIEND_LIST_REQUEST_STATUS_REJECTED.equals(friendListRequestStatus))) {
    		throw new IllegalArgumentException(friendListRequestStatus + " is not a valid transferStatus");
    	}
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsList friendsList = (FriendsList) o;
        return Objects.equals(requestId, friendsList.requestId) &&
                Objects.equals(friendListRequestType, friendsList.friendListRequestType) &&
                friendListRequestStatus == friendsList.friendListRequestStatus &&
                Objects.equals(userFrom, friendsList.userFrom) &&
                Objects.equals(userTo, friendsList.userTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, friendListRequestType, friendListRequestStatus, userFrom, userTo);
    }

    @Override
    public String toString() {
        return "FriendsList{" +
                "requestId=" + requestId +
                ",  friendListRequestType=" + friendListRequestType +
                ", friendListRequestStatus=" + friendListRequestStatus +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                '}';
    }
    
	private static String getInitialStatusForFriendsListRequestType(String friendListRequestType) {
		String friendListRequestStatus = null;
    	if(FriendsList.FRIEND_LIST_REQUEST_TYPE_REQUEST.equals(friendListRequestType)) {
    		friendListRequestStatus = FriendsList.FRIEND_LIST_REQUEST_STATUS_PENDING;
    	} else if(FriendsList.FRIEND_LIST_REQUEST_TYPE_SEND.equals(friendListRequestType)) {
    		friendListRequestStatus = FriendsList.FRIEND_LIST_REQUEST_STATUS_APPROVED;
    	}
		return friendListRequestStatus;
	}
	
}
