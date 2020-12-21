package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Comic;

public interface ComicDAO {
	Comic getComicById(Long comicId);
	List<Comic> getAllComicsByUserId(Long userId);
	List<Comic> getAllComics();
	Comic addComic(Comic comic);
}
