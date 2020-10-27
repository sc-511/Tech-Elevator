package com.techelevator.hotels;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

public class App {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Hotel[] hotels = null;
        Scanner scanner = new Scanner(System.in);
        int menuSelection = 999;

        printGreeting();

        while(menuSelection != 0) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
            if (menuSelection == 1) {
            	
            	Hotel[] arrayOfHotels = getListOfHotels();
            	printHotels(arrayOfHotels);
                
            } else if (menuSelection == 2) {
            	
            	Review [] arrayOfReviews = getArrayOfReviews();
            	printReviews(arrayOfReviews);
                
            } else if (menuSelection == 3) {
            	
            	
                Hotel thisSpecificHotel = getHotel(1);
                printHotel(thisSpecificHotel);
                
            } else if (menuSelection == 4) {
                
            	Review[] thisSpecificReview = getArrayOfReviews(1);
            	printReviews(thisSpecificReview);
            	
            } else if (menuSelection == 5) {
            	
                Hotel [] hotelsWith3Stars = getArrayOfHotelsByRating(3);
                printHotels(hotelsWith3Stars);
                
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            menuSelection = 999;
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            printGreeting();
        }
        scanner.close();
        System.exit(0);
    }

    private static void printGreeting() {
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Hotels. Please make a selection: ");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel ID 1");
        System.out.println("4: List Reviews for Hotel ID 1");
        System.out.println("5: List Hotels with star rating 3");
        System.out.println("6: Custom Query");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
    }

    private static void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    private static void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    private static void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }
    
    private static Hotel[] getListOfHotels(){
  
    	//call the api
    	RestTemplate restTemplate = new RestTemplate();
    	Hotel[] deserializedHotelObjects = restTemplate.getForObject("http://localhost:3000/hotels", Hotel[].class);
    	
    	// deserialize the response into Hotel Objects
    	
    	return deserializedHotelObjects;
    }
    
    private static Review[] getArrayOfReviews() {
    	RestTemplate restTemplate = new RestTemplate();
    	Review[] deserializedReviewObjects = restTemplate.getForObject("http://localhost:3000/reviews", Review[].class);
    	return deserializedReviewObjects;
    }
    
    private static Hotel getHotel(int hotelId) {
    	RestTemplate restTemplate = new RestTemplate();
    	Hotel h = restTemplate .getForObject("http://localhost:3000/hotels/" + hotelId, Hotel.class);
    	return h;
    }
    
    private static Review[] getArrayOfReviews(int hotelId) {
    	RestTemplate restTemplate = new RestTemplate();
    	Review[] output = restTemplate.getForObject("http://localhost:3000/reviews/?hotelID=" + hotelId, Review[].class);
    	return output;
    }
    
    private static Hotel[] getArrayOfHotelsByRating(int starRating) {
    	RestTemplate restTemplate = new RestTemplate();
    	Hotel[] output = restTemplate.getForObject("http://localhost:3000/hotels/?stars=" + starRating, Hotel[].class);
    	return output;
    	
    	/* 
    	 * List <Hotel> list = new ArrayList <> ();
    	 * Hotel[] allHotels = getArrayOfHotels(){
    	 * for (Hotel h : allHotels) {
    	 * if(h.getStars() = 3) {
    	 * 			list.add(h);}
    	 * 		}
    	 * 	Hotel[] threeStarHotels = new Hotel[list.size()];
    	 * 	for (int i = 0; i < threeStarHotels.length; size++)j{
    	 * 	
    	 * 	return threeStarHotels;
    	 * 	}
    	 */
    }
    

}
