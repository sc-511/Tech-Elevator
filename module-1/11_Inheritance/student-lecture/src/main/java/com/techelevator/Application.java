package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        System.out.println("Auction is over...");
        System.out.println(" Winner is: " + generalAuction.getHighBid().getBidder() + " ");
        System.out.println("with a bid of " + generalAuction.getHighBid().getBidAmount() + " dollars!");
        
        
        Auction ra = new ReserveAuction ("Iphone" , 100);
        
        //ReserveAuction ra = new ReserveAuction ("Iphone", 100);
        
        ra.placeBid(new Bid ("Tom", 50));
        ra.placeBid(new Bid("Tom A", 175));
        ra.placeBid( new Bid("Beth", 100));
        ra.placeBid( new Bid ("Walt", 150));
        System.out.println("Just sold: " + ra.getItemForSale());
       
        for (Bid b : ra.getAllBids()) {
        	System.out.println(b.getBidder() + ": " + b.getBidAmount());
        }
        
        
    }
}
