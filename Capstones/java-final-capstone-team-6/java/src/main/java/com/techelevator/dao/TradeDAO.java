package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Trade;

public interface TradeDAO {
	Trade newTrade(Trade someTrade);
	void updateTradeStatus(Trade someTrade);
	List<Trade> getPendingTradesForUser(Long userId);
	List<Trade> getTradesForUser(Long userId);
	Trade getTradeById(Long tradeId);
}
