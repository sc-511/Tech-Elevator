package com.techelevator.model;

import java.util.Objects;

public class StatisticsComicCount {

	private Long accountId;
	private Long userId;
	private Long comicId;
	private String username;
	
	public StatisticsComicCount(Long userId, Long comicId, String username) {
		this.userId = userId;
		this.comicId = comicId;
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getComicId() {
		return comicId;
	}

	public void setComicId(Long comicId) {
		this.comicId = comicId;
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
        StatisticsComicCount comicCount = (StatisticsComicCount) o;
        return accountId == comicCount.accountId &&
                userId == comicCount.userId &&
                username == comicCount.username &&
                comicId.equals(comicCount.comicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, comicId);
    }

    @Override
    public String toString() {
        return "StatisticsComicCount{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", comicId=" + comicId +
                ", username=" + username +
                '}';
    }
	
}
