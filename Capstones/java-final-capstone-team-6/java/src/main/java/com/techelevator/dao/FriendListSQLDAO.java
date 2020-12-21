package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.FriendsList;
import com.techelevator.model.Account;

@Service
public class FriendListSQLDAO implements FriendListDAO{
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	private AccountDAO accountDAO;
	
	private static final String SQL_SELECT_REQUEST = "SELECT friend_list_id, userFrom.username AS UserFrom, userTo.username AS UserTo, fs.friend_request_status_desc AS Status"
						+ " FROM friends_list"
						+ " INNER JOIN users userFrom ON userFrom.user_id = friends_list.user_from "
						+ " INNER JOIN users userTo ON userTo.user_id = friends_list.user_to"
						+ " INNER JOIN friend_request_statuses fs USING (friend_request_status_id)";
	
	private FriendListSQLDAO(JdbcTemplate jdbcTemplate, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.userDAO = userDAO;
	}
	
	
	@Override
	public FriendsList newRequest(FriendsList someRequest) {
		String sql = "INSERT INTO friends_list(friend_list_id, friend_request_type_id, friend_request_status_id, user_from, user_to) VALUES (?, ?, ?, ?, ?)";
		Long newRequestId = getNextRequestId();
		Long requestTypeId = getRequestTypeId(someRequest.getRequestType());
		Long requestStatusId = getRequestStatusId(someRequest.getRequestStatus());
		Long userFrom = someRequest.getUserFrom();
		Long userTo = someRequest.getUserTo();
		
		jdbcTemplate.update(sql, newRequestId, requestTypeId, requestStatusId, userFrom, userTo);
		return getRequestById(newRequestId);
	}

	@Override
	public void updateRequestStatus(FriendsList someRequest) {
		String sql = "UPDATE friends_list SET friend_request_status_id = ? WHERE friend_list_id = ?";
		Long requestStatusId = getRequestStatusId(someRequest.getRequestStatus());
		jdbcTemplate.update(sql, requestStatusId, someRequest.getRequestId());
	}
	
	@Override
	public List<FriendsList> getAllRequests (){
		List <FriendsList> friendsLists = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(SQL_SELECT_REQUEST);
		while(results.next()) {
			FriendsList friends = mapRowToFriendsList(results);
			friendsLists.add(friends);
		}
		return friendsLists;
	}
	
	@Override
	public List<FriendsList> getApprovedRequestsForUser(Long userId){
		List<FriendsList> friendsLists = new ArrayList<>();
		String sql = "SELECT userFrom.username AS UserFrom, userTo.username AS UserTo, fs.friend_request_status_desc AS Status"
				+ " FROM friends_list"
				+ " INNER JOIN users userFrom ON userFrom.user_id = friends_list.user_from "
				+ " INNER JOIN users userTo ON userTo.user_id = friends_list.user_to"
				+ " INNER JOIN friend_request_statuses fs USING (friend_request_status_id)"
				+ " WHERE (userFrom.user_id = ? OR userTo.user_id = ?) AND friend_request_status_id = 2";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
		while(results.next()) {
			FriendsList friends = mapRowToFriendsList(results);
			friendsLists.add(friends);
		}
		return friendsLists;
	}

	@Override
	public String getRequestType(Long requestTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequestStatus(Long requestStatusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FriendsList> getPendingRequestsForUser(Long userId) {
		String sql = SQL_SELECT_REQUEST + "WHERE (userFrom.user_id = ? OR userTo.user_id = ?) AND friend_request_status_id = 1)";
		List<FriendsList> friendsLists = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
		while(results.next()) {
			FriendsList friendsList = mapRowToFriendsList(results);
			friendsLists.add(friendsList);
		}
		return friendsLists;
	}
	
	@Override
	public FriendsList getRequestById(Long requestId) {
		FriendsList friendsList = null;
		String sql = SQL_SELECT_REQUEST + "WHERE friend_list_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestId);
		if(results.next()) {
			friendsList = mapRowToFriendsList(results);
		}
		return friendsList;
	}
	
	private Long getNextRequestId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_friends_list_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new request");
		}
	}
	
	private Long getRequestTypeId(String friendRequestType) {
		String sql = "SELECT friend_request_type_id FROM friend_request_types WHERE friend_request_type_desc = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, friendRequestType);
		if(results.next()) {
			return results.getLong(1);
		} else {
			throw new RuntimeException("Unable to lookup friend request type " + friendRequestType);
		}
	}
	
	private Long getRequestStatusId(String friendRequestStatus) {
		String sql = "SELECT friend_request_status_id FROM friend_request_statuses WHERE friend_request_status_desc = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, friendRequestStatus);
		if(results.next()) {
			return results.getLong(1);
		} else {
			throw new RuntimeException("Unable to lookup friend request status " + friendRequestStatus);
		}
	}
	private FriendsList mapRowToFriendsList(SqlRowSet rs) {
		return new FriendsList(rs.getLong("friend_list_id"),
				rs.getString("friend_request_type_desc"),
				rs.getString("friend_request_status_desc"),
				rs.getLong("user_from"),
				rs.getLong("user_to"));
	}
}
