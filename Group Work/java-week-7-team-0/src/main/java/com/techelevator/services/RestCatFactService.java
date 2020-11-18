package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;

@Component
public class RestCatFactService implements CatFactService {
	
	//private CatFact fact = new CatFact();
	private String url = "https://cat-fact.herokuapp.com/facts/random";
	
	@Override
	public CatFact getFact() {
		RestTemplate restTemplate = new RestTemplate();
		CatFact fact = restTemplate.getForObject(url,CatFact.class);
		return fact;
	}

}
