package com.techelevator.model;

public class Collection {
	
	private Long collectionId;
	private Long userId;
	private String collectionName;
	private String collectionDescription;
	private Long favorite_status_id;
	private Long collection_visibility_id;
	private String userName;
	
	public Collection(Long collectionId, Long userId, String collectionName, String collectionDesc, Long favorite_status_id, Long collection_visibility_id) {
		this.collectionId = collectionId;
		this.userId = userId;
		this.collectionName = collectionName;
		this.collectionDescription = collectionDesc;
		this.favorite_status_id = favorite_status_id;
		this.collection_visibility_id = collection_visibility_id;
	}
	public Collection(String collectionName, String collectionDescription, String userName ) {
		this.collectionName = collectionName;
		this.collectionDescription = collectionDescription;
		this.userName = userName;
	}
	
	public Long getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}
	public String getCollectionName() {
		return collectionName;
	}
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	public String getCollectionDescription() {
		return collectionDescription;
	}
	public void setCollectionDescription(String collectionDescription) {
		this.collectionDescription = collectionDescription;
	}
	public void setFavoriteStatusId(Long favorite_status_id) {
		this.favorite_status_id  = favorite_status_id;
	}
	public Long getFavoriteStatusId() {
		return favorite_status_id;
	}
	public void setCollectionVisibilityId(Long collection_visibility_id) {
		this.collection_visibility_id = collection_visibility_id;
	}
	public Long getCollectionVisibilityId() {
		return collection_visibility_id;
	}
	public Long getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	
	
	
}
