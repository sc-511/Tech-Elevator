package com.techelevator;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    Card c = new Card ("Hearts", "Queen");
    	
    	System.out.println(c.cardString());
    	
    	c.flip();
    	
    	System.out.println(c.cardString());
    	
    	
    }
    	
    	
    	public static void mainRectangle(String[]args) {
    		
    	
        System.out.println( "Running!" );
        
        Rectangle r2 = new Rectangle();
        r2.setName("Not Steve");
        Rectangle r1 = new Rectangle("Steve", 100, 200);
        
        
        
        r1.print();
        
        System.out.println("Rectangle r1 is " + r1.getWidth() + " wide by " + r1.getHeight());
        System.out.println("Its area is: " + r1.getArea());
    }
}
