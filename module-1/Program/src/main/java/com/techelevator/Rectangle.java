package com.techelevator;

public class Rectangle {

	// Access Modifiers: Public / Private
	
	private String name;
	private int height;
	private int width;
	
	//CONTSTRUCTOR
	public Rectangle(String name, int height, int width) {
		this.name = name;
		this.height = height;
		this.width = width;
	}
	
	//DEFAULT CONSTRUCTOR
	public Rectangle() {}
	
	
	
	//SETTERS
	public void setName(String name) {
		 //heap to incoming parameter
		this.name = name;
	}
	
	public void setHeight(int height) {
		 //heap to incoming parameter
		this.height = height;
		
	}
	
	public void setWidth(int width) {
		 //heap to incoming parameter
		this.width = width;
		
	}

	
	//GETTERS
	
	public int getArea() {
		return this.width * this.height;
	}
	
	public int getHeight() {
		return height;
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public String getName() {
		return name;
	}
	
		public void print() {
			
			System.out.println("This rectangle's name is: " + name);
		}
		

	}


