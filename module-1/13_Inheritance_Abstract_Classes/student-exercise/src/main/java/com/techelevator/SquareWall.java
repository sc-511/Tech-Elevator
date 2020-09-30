package com.techelevator;

public final class SquareWall extends RectangleWall {

	 
	
	 public SquareWall(String name, String color, int sideLength) {
		super(name, color, sideLength, sideLength);
		
	}
	
	public String toString() {
		return super.getName() + " " + "(" + getLength()+ "x" + getHeight() + ")" + " " + "square";
	}

}
