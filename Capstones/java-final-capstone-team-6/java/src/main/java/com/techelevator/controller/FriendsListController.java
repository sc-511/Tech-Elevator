package com.techelevator.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.FriendListDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.FriendsList;
import com.techelevator.model.FriendsListAuthorization;
import com.techelevator.model.NewFriendRequestDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@RequestMapping("/friendslist")
@PreAuthorize("isAuthenticated()")
public class FriendsListController {
	private FriendListDAO friendListDAO;
	private AccountDAO accountDAO;
	private UserDAO userDAO;
	
	public FriendsListController(FriendListDAO friendListDAO, AccountDAO accountDAO, UserDAO userDAO) {
		this.friendListDAO = friendListDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}

	//Do we add an ID to the pathway to create a certain friend request?
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public FriendsList createRequest(@Valid @RequestBody NewFriendRequestDTO friendRequestDTO, Principal principal) {
		FriendsList friendsList = buildRequestFromRequestDTO(friendRequestDTO);
		
		friendsList = friendListDAO.newRequest(friendsList);
		if(friendsList.isApproved()) {
			return friendsList;
		}
		return friendsList;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List <FriendsList> allCurrentUsersFriends(Principal principal){
		List <FriendsList> allFriends = new ArrayList<>();
		Long userId = getCurrentUserId(principal);
		return friendListDAO.getApprovedRequestsForUser(userId);
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List <FriendsList> allRequests (Principal principal){
		List <FriendsList> allRequests = new ArrayList<>();
		allRequests = friendListDAO.getAllRequests();
		return allRequests;
	}
	
	//Do we add an ID to the pathway to delete a certain friend request?
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteRequest(@Valid @RequestBody NewFriendRequestDTO friendRequestDTO, Principal principal) {
		FriendsList friendsList = buildRequestFromRequestDTO(friendRequestDTO);
		
	}
	
	
	private FriendsList buildRequestFromRequestDTO(NewFriendRequestDTO friendRequestDTO) {
		Long userFrom = friendRequestDTO.getUserFrom();
		Long userTo = friendRequestDTO.getUserTo();
		
		return new FriendsList(friendRequestDTO.getFriendListRequestType(),
								userFrom,
									userTo);
	}
	
	private Long getCurrentUserId(Principal principal) {
		return userDAO.findByUsername(principal.getName()).getId();
	}
	
	
	
}


