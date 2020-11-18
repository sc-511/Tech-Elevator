package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/cards")
public class CatController {

	@Autowired 
    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;
    private RestTemplate restTemplate;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
    @RequestMapping( method = RequestMethod.GET)
    public List<CatCard> list() {
    	return catCardDao.list();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET) 
    	public CatCard get(@PathVariable long id) throws CatCardNotFoundException{
    		return catCardDao.get(id);
    	}
    
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard random() {
    	return catCardDao.get(new Random().nextLong());
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody CatCard cardToSave) {
    	
    	 catCardDao.save(cardToSave);
    	 
    	return true;
    }
   
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean update(@Valid @RequestBody CatCard card, @PathVariable long id) throws CatCardNotFoundException{
    	catCardDao.update(id, card);
    	return true;
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) throws CatCardNotFoundException {
    	
    	 catCardDao.delete(id);
    	 return true;
    }
}
