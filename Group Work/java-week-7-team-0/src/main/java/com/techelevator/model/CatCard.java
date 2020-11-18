package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class CatCard {

	public Long catCardId;
	
	@NotEmpty (message = "The field `catFact` should not be blank.")
	public String catFact;
	
	@NotEmpty (message = "The field `imgUrl` should not be blank.")
	public String imgUrl;
	
	@NotEmpty (message = "The field `caption` should not be blank.")
	public String caption;

	public Long getCatCardId() {
		return catCardId;
	}
	public void setCatCardId(Long catCardId) {
		this.catCardId = catCardId;
	}
	
	public String getCatFact() {
		return catFact;
	}
	public void setCatFact(String catFact) {
		this.catFact = catFact;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
