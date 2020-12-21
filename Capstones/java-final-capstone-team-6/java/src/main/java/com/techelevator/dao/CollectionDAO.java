package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Collection;

public interface CollectionDAO {
	Collection getCollectionById(Long collectionId);
	List<Collection> getAllCollectionsByUserId(Long userId);
	List<Collection> getAllPublicCollections();
	Collection newCollection(Collection collection, Long currentUserId);
	void updateCollectionName(Collection someCollection);
	void updateCollectionDesc(Collection someCollection);
	void updateCollectionFavoriteStatusId(Collection someCollection);
	void updateCollectionVisibilityId(Collection someCollection);
	void deleteCollection(Collection someCollection);

}
