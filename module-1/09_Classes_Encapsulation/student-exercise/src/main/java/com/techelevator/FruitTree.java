package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	private int startingPiecesOfFruit;
	
	public FruitTree (String typeOfFruit, int startingPiecesOfFruit) {
		
		this.typeOfFruit = typeOfFruit;
		
		this.startingPiecesOfFruit = startingPiecesOfFruit;
		
	}
		
		
	public FruitTree() {}

	public String getTypeOfFruit() {
		
		return typeOfFruit;
	}

	public int getPiecesOfFruitLeft() {
		
		return piecesOfFruitLeft;
	}
	
	public boolean pickFruit (int numberOfPiecesToRemove) {
		
		if (startingPiecesOfFruit > 0 && startingPiecesOfFruit > numberOfPiecesToRemove) {
				
			piecesOfFruitLeft = startingPiecesOfFruit - numberOfPiecesToRemove;
			return true;
			
			}
			
		else if (startingPiecesOfFruit > 0 && startingPiecesOfFruit < numberOfPiecesToRemove) {	
			
			piecesOfFruitLeft = startingPiecesOfFruit;
			return true;
				
		}
		else {
			return false;
		}
			
			
	
			
				
		}
}
