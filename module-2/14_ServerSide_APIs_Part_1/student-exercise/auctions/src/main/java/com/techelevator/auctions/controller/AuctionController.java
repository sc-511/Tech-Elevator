package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auctions")
public class AuctionController {

    private AuctionDAO dao;
    
    
    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> searching(@RequestParam(value = "title_like", defaultValue = "")String title_like, @RequestParam (value = "currentBid_lte", defaultValue = "0") double currentBid_lte){
    	
    	if (title_like == " " && currentBid_lte == 0) {
    		
    		return dao.list();
    	}
    	else if (title_like != " " && currentBid_lte == 0) {
    		
    		return dao.searchByTitle(title_like);
    	
    	}
    	
    	else if (title_like == " " && currentBid_lte > 0) {
    		
    		return dao.searchByPrice(currentBid_lte);
    	}
    	
    	else {
    		return dao.searchByTitleAndPrice(title_like, currentBid_lte);
    	}
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
    	return dao.get(id);
	}
    
    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
    	return dao.create(auction);
    }
    
//    @RequestMapping(path = "?",method = RequestMethod.GET)
//    public List<Auction> searchByTitle({
//    	
//    	if (title_like != null) {
//    		
//    		return dao.searchByTitle(title_like);
//    	}
//    	
//    	else {
//    		
//    		return dao.list();
//    	}
//    	
//    }
    
//    @RequestMapping( method = RequestMethod.GET)
//    public List <Auction> searchByPrice(@RequestParam(value = "currentBid", defaultValue = "0") double currentBid_lte){
//		return dao.searchByPrice(currentBid_lte);
//    	
//    }
//    
//    @RequestMapping(method = RequestMethod.GET)
//    public List <Auction> searchByTitleAndPrice (@RequestParam (value = "title", defaultValue = " ") String title_like, @RequestParam (value = "currentBid", defaultValue = "0") double currentBid_lte){
//		return dao.searchByTitleAndPrice(title_like, currentBid_lte);
//    	
//    }
    
    
}
