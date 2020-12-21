package com.techelevator.model;

import java.util.Objects;

public class StatisticsComicCondition {

	private Long accountId;
	private Long userId;
	private Long comicConditionId;
	private String username;
	
	public static final Long MINT_COMIC_CONDITION = 1L;
	public static final Long FAIR_COMIC_CONDITION = 2L;
	public static final Long POOR_COMIC_CONDITION = 3L;
	
	public StatisticsComicCondition(Long accountId, Long userId, Long comicConditionId, String username) {
		this.accountId = accountId;
		this.userId = userId;
		this.comicConditionId = comicConditionId;
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

	public Long getComicConditionId() {
		return comicConditionId;
	}

	public void setComicConditionId(Long comicConditionId) {
		this.comicConditionId = comicConditionId;
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
        StatisticsComicCondition comicCondition = (StatisticsComicCondition) o;
        return accountId == comicCondition.accountId &&
                userId == comicCondition.userId &&
                username == comicCondition.username &&
                comicConditionId.equals(comicCondition.comicConditionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userId, comicConditionId, username);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", comicConditionId=" + comicConditionId +
                ", username=" + username +
                '}';
    }
	
}
