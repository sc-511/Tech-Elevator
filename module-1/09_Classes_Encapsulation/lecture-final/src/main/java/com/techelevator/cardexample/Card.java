package com.techelevator.cardexample;

public class Card {
	
	private int suit;
	private int rank;
	private boolean faceUp = false;

	/**
	 * Construct a Card object of suit and rank
	 * 
	 * @param suit
	 * @param rank
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Flip (toggle set) face-up / face-down.
	 */
	public void flip() {
		faceUp = !faceUp;
	}

	/**
	 * Get card's suit.
	 * 
	 * @return suit
	 */
	public int getSuit() {
		return this.suit;
	}

	/**
	 * Get card's  rank.
	 * 
	 * @return rank
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Get whether card is face-up.
	 * 
	 * @return true (face-up) / false (face-down)
	 */
	public boolean isFaceUp() {
		return faceUp;
	}

	/**
	 * Builds string presentation of a card depending
	 * upon the value of the instance variable, faceUp.
	 * 
	 * @return string representation of card
	 */
	public String cardString() {
		return cardString(this.faceUp);
	}
	
	/**
	 * Overload of cardString() which uses the faceUp
	 * parameter rather than the instance variable
	 * to determine which string representation of the
	 * card to return, the face or the back.
	 * 
	 * @param faceUp, if true, then card is face-up, otherwise face-down
	 * 
	 * @return string presentation of card
	 */
	public String cardString(boolean faceUp) {
		if (faceUp) {
			return Game.getRankName(rank) + Game.getSuitSymbol(suit);
		} else {
			return "##";
		}
	}
}
