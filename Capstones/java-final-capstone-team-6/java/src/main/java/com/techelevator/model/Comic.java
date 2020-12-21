package com.techelevator.model;

import java.util.Date;

public class Comic {
	private Long comicId;
	private String comicName;
	private String authorName;
	private String comicCharacters;
	private Date datePublished;
	
	public Comic(Long comicId, String comicName, String authorName, String comicCharacters,  Date datePublished) {
		this.comicId = comicId;
		this.comicName = comicName;
		this.authorName = authorName;
		this.comicCharacters = comicCharacters;
		this.datePublished = datePublished;
	}
	
	public Long getComicId() {
		return comicId;
	}
	
	public String getComicName() {
		return comicName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getComicCharacters() {
		return comicCharacters;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	
	
	
}
