package com.techelevator;

public class RectangleWall extends Wall{

	private int length;
	private int height;
	
	
	
	public RectangleWall(String name, String color, int length, int height) {
		super(name, color);
		this.length = length;
		this.height = height;
	}
	

	public int getLength() {
		return length;
	}



	public int getHeight() {
		return height;
	}

	public String toString() {
		return super.getName() + " " + "(" + length + "x" + height + ")" + " " + "rectangle";
	}

	@Override
	public int getArea() {
		
		return length * height;
	}

}
