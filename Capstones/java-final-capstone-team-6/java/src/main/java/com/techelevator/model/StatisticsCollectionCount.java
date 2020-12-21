package com.techelevator.model;

import java.util.Objects;

public class StatisticsCollectionCount {

	private Long accountId;
	private Long userId;
	private Long collectionId;
	private String username;
	
	public StatisticsCollectionCount(Long accountId, Long userId, Long collectionId, String username) {
		this.accountId = accountId;
		this.userId = userId;
		this.collectionId = collectionId;
		this.username = username;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsCollectionCount collectionCount = (StatisticsCollectionCount) o;
        return accountId == collectionCount.accountId &&
                userId == collectionCount.userId &&
                username == collectionCount.username &&
                collectionId.equals(collectionCount.collectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, collectionId, username);
    }

    @Override
    public String toString() {
        return "StatisticsCollectionCount{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", comicId=" + collectionId +
                ", username=" + username +
                '}';
    }
}
