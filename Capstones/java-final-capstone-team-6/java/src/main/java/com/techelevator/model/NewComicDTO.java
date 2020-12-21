package com.techelevator.model;

import java.util.Date;

public class NewComicDTO {
	private Long comicId;
	private String comicName;
	private String authorName;
	private String comicCharacters;
	private Date datePublished;
	
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public String getComicName() {
		return comicName;
	}
	public void setComicName(String comicName) {
		this.comicName = comicName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	public String getComicCharacters() {
		return comicCharacters;
	}
	public void setComicCharacters(String comicCharacters) {
		this.comicCharacters = comicCharacters;
	}
	
	
}
