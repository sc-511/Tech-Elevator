package com.techelevator.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Collection;
import com.techelevator.model.Comic;

@Service
public class ComicSQLDAO implements ComicDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	
	public ComicSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Comic getComicById(Long comicId) {
		Comic comic = null;
		String sql = "SELECT * FROM comics WHERE comic_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, comicId);
		while(results.next()) {
			comic = mapRowToComic(results);
		}
		return comic;
	}
	
	@Override
	public List<Comic> getAllComics() {
		List<Comic> comic = new ArrayList<>();
		String sql = "SELECT * FROM comics";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Comic comics = mapRowToComic(results);
			comic.add(comics);
		}
		return comic;
	}

	@Override
	public List<Comic> getAllComicsByUserId(Long userId) {
		List<Comic> comic = new ArrayList<>();
		String sql = "SELECT comic_id, comic_name, author_name, comic_characters, date_published FROM comics "
				+ "INNER JOIN accounts USING (comic_id)"
				+ " INNER JOIN users USING (user_id) "
				+ "WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while(results.next()) {
			Comic comics = mapRowToComic(results);
			comic.add(comics);
			
		}
		return comic;
	}

	@Override
	public Comic addComic(Comic comic) {
		String sql = "INSERT INTO comics (comic_id, comic_name, author_name, comic_characters, date_published) VALUES (?, ?, ?, ?, ?)";
		Long comicId = comic.getComicId();
		String comicName = comic.getComicName();
		String authorName = comic.getAuthorName();
		String comicCharacters = comic.getComicCharacters();
		Date datePublished = comic.getDatePublished();
		
		jdbcTemplate.update(sql, comicId, comicName, authorName, comicCharacters, datePublished);
		return getComicById(comicId);
	}

	private Long getNextComicId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_comic_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for a new comic");
		}
	}
	
	private Comic mapRowToComic (SqlRowSet rs) {
		return new Comic(rs.getLong("comic_id"),
				rs.getString("comic_name"), 
				rs.getString("author_name"),
				rs.getString("comic_characters"),
				rs.getDate("date_published")); 
		
	}

	
}
