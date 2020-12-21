package com.techelevator.model;

public class NewCollectionDTO {
	private Long collectionId;
	private Long userId;
	private String collectionName;
	private String collectionDescription;
	private Long favorite_status_id;
	private Long collection_visibility_id;
	
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
	public Long getFavoriteStatusId() {
		return favorite_status_id;
	}
	public void setFavoriteStatusId(Long favorite_status_id) {
		this.favorite_status_id = favorite_status_id;
	}
	public Long getCollectionVisibilityId() {
		return collection_visibility_id;
	}
	public void setCollectionVisibilityId(Long collection_visibility_id) {
		this.collection_visibility_id = collection_visibility_id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
}
