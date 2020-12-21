package com.techelevator.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.AccountDAO;
import com.techelevator.dao.ComicDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.Account;
import com.techelevator.model.AccountAuthorization;
import com.techelevator.model.AuthorizationException;
import com.techelevator.model.Comic;
import com.techelevator.model.ComicAuthorization;
import com.techelevator.model.NewComicDTO;

@RestController
@CrossOrigin
@RequestMapping("/comics")
public class ComicController {
	private ComicDAO comicDAO;
	private AccountDAO accountDAO;
	private UserDAO userDAO;

	public ComicController(ComicDAO comicDAO, AccountDAO accountDAO, UserDAO userDAO) {
		this.comicDAO = comicDAO;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public Comic getComic(@PathVariable Long id) {
		Comic comic = comicDAO.getComicById(id);
		return comic;
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public List <Comic> getAllComics (){
		List <Comic> allComics = comicDAO.getAllComics();
		return allComics;
	}
	
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Comic addComic(@Valid @RequestBody NewComicDTO comicDTO, Principal principal) {
		Comic comic = buildComicFromComicDTO(comicDTO);
		//validateAuthorizationToCreate(principal, comic);
		comic = comicDAO.addComic(comic);
		return comic;
	}

    private Comic buildComicFromComicDTO(NewComicDTO comicDTO) {
    	return new Comic(comicDTO.getComicId(),
    						comicDTO.getComicName(),
    						comicDTO.getAuthorName(),
    						comicDTO.getComicCharacters(),
    						comicDTO.getDatePublished()
    						);
		
    }
    

}
