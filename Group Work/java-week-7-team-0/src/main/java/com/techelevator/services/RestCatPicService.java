package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {
	//private CatPic pic = new CatPic();
	private String url = "https://random-cat-image.herokuapp.com";
	private String filePath = "file\":\"https:\\/\\/purr.objects-us-east-1.dream.io\\/i\\/VEcIJ.jpg";
	
	@Override
	public CatPic getPic() {
		//pic.setFile(filePath);
		RestTemplate restTemplate = new RestTemplate();
		CatPic pic = restTemplate.getForObject(url,  CatPic.class);
		return pic;
	}
	
	
	

}	
