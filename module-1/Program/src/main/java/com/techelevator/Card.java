package com.techelevator;

public class Card {
	
	private String suit;
	private String rank;
	private boolean faceUp = false;
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	
	}
	
	public void flip() {
		
		this.faceUp = !this.faceUp;
	}
	
	public String cardString() {
		
		if(this.faceUp) {
			return this.rank + " of " + this.suit;
		}
		
		else {
			return "###";
		}
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getRank() {
		return rank;
	}
	
	public boolean isFaceUp() {
		return faceUp;
	}
	
	
}
