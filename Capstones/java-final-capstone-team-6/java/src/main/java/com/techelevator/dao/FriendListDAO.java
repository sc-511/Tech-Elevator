package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.FriendsList;

public interface FriendListDAO {
	FriendsList newRequest(FriendsList someRequest);
	void updateRequestStatus(FriendsList someRequest);
	List<FriendsList> getAllRequests ();
	List<FriendsList> getApprovedRequestsForUser(Long userId);
	String getRequestType(Long requestTypeId);
	String getRequestStatus(Long  requestStatusId);
	List<FriendsList> getPendingRequestsForUser(Long userId);
	FriendsList getRequestById(Long requestId);
}
