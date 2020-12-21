package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.CollectionDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.Collection;
import com.techelevator.model.CollectionAuthorization;
import com.techelevator.model.NewCollectionDTO;
import com.techelevator.model.Trade;
import com.techelevator.model.TradeAuthorization;

@RestController
@CrossOrigin
@RequestMapping("/collections")
public class CollectionController {
	private AccountDAO accountDAO;
	private CollectionDAO collectionDAO;
	private UserDAO userDAO;

	
	public CollectionController(CollectionDAO collectionDAO, AccountDAO accountDAO, UserDAO userDAO) {
		this.collectionDAO = collectionDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Collection getCollection (@PathVariable Long id) {
		Collection collection = collectionDAO.getCollectionById(id);
		return collection;
	}
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public List <Collection> getAllPublicCollections(){
		List <Collection> publicCollections = collectionDAO.getAllPublicCollections();
		return publicCollections;
	}
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value="/mycollections", method = RequestMethod.GET)
	public List <Collection> getAllCollectionsByUser(Principal principal) {
		List <Collection> allCollections = collectionDAO.getAllCollectionsByUserId(getCurrentUserId(principal));
		return allCollections;
	}
	
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Collection createCollection(@Valid @RequestBody NewCollectionDTO collectionDTO, Principal principal) {
		Collection collection = buildCollectionFromCollectionDTO(collectionDTO);
		collection = collectionDAO.newCollection(collection, getCurrentUserId(principal));
		return collection;
	}
	
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Collection deleteCollection(@PathVariable Long id) {
		Collection collection = collectionDAO.getCollectionById(id);
		return collection;
	}
	
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public Collection updateCollectionDetails(@Valid @RequestBody NewCollectionDTO newCollectionDTO, @PathVariable Long id) {		
		Collection collection = collectionDAO.getCollectionById(id);
		if(newCollectionDTO.getCollectionName() != null && newCollectionDTO.getCollectionName().length() > 0 ) {
			collection.setCollectionName(newCollectionDTO.getCollectionName());
			collectionDAO.updateCollectionName(collection);
		}
		if (newCollectionDTO.getCollectionDescription() != null ) {
			collection.setCollectionDescription(newCollectionDTO.getCollectionDescription());
			collectionDAO.updateCollectionDesc(collection);
		}
		collection.setFavoriteStatusId(newCollectionDTO.getFavoriteStatusId());
		collectionDAO.updateCollectionFavoriteStatusId(collection);
		collection.setCollectionVisibilityId(newCollectionDTO.getCollectionVisibilityId());
		collectionDAO.updateCollectionVisibilityId(collection);
		return collection;
		
	}
	

	
	
	private Collection buildCollectionFromCollectionDTO(NewCollectionDTO collectionDTO) {
		return new Collection (collectionDTO.getCollectionId(),
				collectionDTO.getUserId(),
				collectionDTO.getCollectionName(),
				collectionDTO.getCollectionDescription(),
				collectionDTO.getFavoriteStatusId(),
				collectionDTO.getCollectionVisibilityId());
	}
	
	private void validateAuthorizationToCreate(Principal principal, Collection collection) {
		CollectionAuthorization auth = new CollectionAuthorization(principal, collection);
        if(!auth.isAllowedToCreate()) {
        	throw new AuthorizationException();
        }
	}
	
	 private Long getCurrentUserId(Principal principal) {
	        return userDAO.findByUsername(principal.getName()).getId();
	    }
}