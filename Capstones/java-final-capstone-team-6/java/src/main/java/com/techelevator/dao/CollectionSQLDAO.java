package com.techelevator.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Collection;

@Service
public class CollectionSQLDAO implements CollectionDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	
	public CollectionSQLDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	@Override
	public Collection getCollectionById(Long collectionId) {
		Collection collection = null;
		String sql = "SELECT collection_id, user_id, collection_name, collection_desc, favorite_status_id, collection_visibility_id FROM collections WHERE collection_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId);
		while(results.next()) {
			collection = mapRowToCollection(results);
		}
		return collection;
	}

	@Override
	public List<Collection> getAllCollectionsByUserId(Long userId) {
		List<Collection> collection = new ArrayList<>();
		String sql = "SELECT collection_id, user_id, collection_name, collection_desc, favorite_status_id, collection_visibility_id FROM collections "
				+ "WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while(results.next()) {
			Collection collections = mapRowToCollection(results);
			collection.add(collections);
			
		}
		return collection;
	}

	@Override
	public Collection newCollection(Collection collection, Long currentUserId) {
		String sql = "INSERT INTO collections(collection_id, user_id, collection_name, collection_desc, favorite_status_id, collection_visibility_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Long newCollectionId = getnextCollectionId();
		Long userId = currentUserId;
		String collectionName = collection.getCollectionName();
		String collectionDesc = collection.getCollectionDescription();
		Long favoriteStatusId = collection.getFavoriteStatusId();
		Long collectionVisibilityId = collection.getCollectionVisibilityId();
		
		jdbcTemplate.update(sql, newCollectionId, userId, collectionName, collectionDesc, favoriteStatusId, collectionVisibilityId);
		return getCollectionById(newCollectionId);
	}
	
	@Override
	public List<Collection> getAllPublicCollections(){
		List<Collection> collection = new ArrayList<>();
		String sql = "SELECT collection_name, collection_desc, username " +		       
				"FROM collections " +
		        "INNER JOIN users ON users.user_id = collections.user_id " +
		        "WHERE collection_visibility_id = 2";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Collection collections = mapRowToPublicCollections(results);
			collection.add(collections);
		}
		return collection;
	}
	
	private Long getnextCollectionId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_collection_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new collection");
		}
	}

	@Override
	public void updateCollectionName(Collection someCollection) {
		String sql = "UPDATE collections SET collection_name = ? WHERE collection_id = ?";
		String collectionName = someCollection.getCollectionName();
		jdbcTemplate.update(sql, collectionName, someCollection.getCollectionId());
		
	}

	@Override
	public void updateCollectionDesc(Collection someCollection) {
		String sql = "UPDATE collections SET collection_desc = ? WHERE collection_id = ?";
		String collectionDesc = someCollection.getCollectionDescription();
		jdbcTemplate.update(sql, collectionDesc, someCollection.getCollectionId());
		
	}
	
	@Override
	public void updateCollectionFavoriteStatusId(Collection someCollection) {
		String sql = "UPDATE collections SET favorite_status_id = ? WHERE collection_id = ?";
		Long collectionFavoriteStatusId = someCollection.getFavoriteStatusId();
		jdbcTemplate.update(sql, collectionFavoriteStatusId, someCollection.getCollectionId());
		
	}

	@Override
	public void updateCollectionVisibilityId(Collection someCollection) {
		String sql = "UPDATE collections SET collection_visibility_id = ? WHERE collection_id = ?";
		Long collectionVisibilityId = someCollection.getCollectionVisibilityId();
		jdbcTemplate.update(sql, collectionVisibilityId, someCollection.getCollectionId());		
	}
	
	

	@Override
	public void deleteCollection(Collection someCollection) {
		String sql = "DELETE FROM collections WHERE collection_id = ?";
		jdbcTemplate.update(sql, someCollection.getCollectionId());
		
	}
	
	private Collection mapRowToCollection (SqlRowSet rs) {
		return new Collection(rs.getLong("collection_id"),
				rs.getLong("user_id"),
				rs.getString("collection_name"), 
				rs.getString("collection_desc"),
				rs.getLong("favorite_status_id"),
				rs.getLong("collection_visibility_id")); 
		
	}
	
	private Collection mapRowToPublicCollections (SqlRowSet rs) {
		return new Collection (rs.getString("collection_name"),
				rs.getString("collection_desc"),
				rs.getString("username"));
	}


	

	
}
