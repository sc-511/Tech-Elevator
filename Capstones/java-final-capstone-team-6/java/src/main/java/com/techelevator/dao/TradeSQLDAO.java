package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.Account;
import com.techelevator.model.Trade;


@Service
public class TradeSQLDAO implements TradeDAO{
	private JdbcTemplate jdbcTemplate;
	private UserDAO userDAO;
	private AccountDAO accountDAO;
	
	 private static final String SQL_SELECT_TRADE = "SELECT t.trade_id, tt.trade_type_desc, ts.trade_status_desc, t.comic_id, " +
	            "aFrom.account_id as fromAcct, aFrom.user_id as fromUser, aFrom.comic_id as fromComic, " +
	            "aTo.account_id as toAcct, aTo.user_id as toUser, aTo.comic_id as toComic " +
	            "FROM trades t " +
	            "INNER JOIN trade_types tt ON t.trade_type_id = tt.trade_type_id "+
	            "INNER JOIN trade_statuses ts ON t.trade_status_id = ts.trade_status_id "+
	            "INNER JOIN accounts aFrom on account_from = aFrom.account_id " +
	            "INNER JOIN accounts aTo on account_to = aTo.account_id ";
	
	private TradeSQLDAO(JdbcTemplate jdbcTemplate, AccountDAO accountDAO, UserDAO userDAO) {
		this.jdbcTemplate = jdbcTemplate;
		this.accountDAO = accountDAO;
		this.userDAO = userDAO;
	}
	
	@Override
	public Trade newTrade(Trade someTrade) {
		String sql = "INSERT INTO trades(trade_id, trade_type_id, trade_status_id, account_from, account_to, comic_id) VALUES (?, ?, ?, ?, ?,?)";
		Long newTradeId = getnextTradeId();
		Long tradeTypeId = getTradeTypeId(someTrade.getTradeType());
		Long tradeStatusId = getTradeStatusId(someTrade.getTradeStatus());
		Account fromAccount = accountDAO.getAccountByUserId(someTrade.getUserFrom().getId());
		Account toAccount = accountDAO.getAccountByUserId(someTrade.getUserTo().getId());
		
		jdbcTemplate.update(sql, newTradeId, tradeTypeId, tradeStatusId, fromAccount.getAccountId(), toAccount.getAccountId(), someTrade.getComicId());
		return getTradeById(newTradeId);
	}

	@Override
	public void updateTradeStatus(Trade someTrade) {
		String sql = "UPDATE trades SET trade_status_id = ? WHERE trade_id = ?";
		Long tradeStatusId = getTradeStatusId(someTrade.getTradeStatus());
		jdbcTemplate.update(sql, tradeStatusId, someTrade.getTradeId());
		
	}

	@Override
	public List<Trade> getPendingTradesForUser(Long userId) {
		 String sql = SQL_SELECT_TRADE + "WHERE trade_status_id = 1 AND account_from IN (SELECT account_id FROM accounts WHERE user_id = ?)";
	        List<Trade> trades = new ArrayList<>();
	        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
	        while(results.next()) {
	            Trade trade = mapRowToTrade(results);
	            trades.add(trade);
	        }
	        return trades;
	}
	
	@Override
	public Trade getTradeById(Long tradeId) {
		Trade trade = null;
		String sql = SQL_SELECT_TRADE + "WHERE trade_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,tradeId);
		if(results.next()) {
			trade = mapRowToTrade(results);
		}
		return trade;
	}
	
	@Override
	public List<Trade> getTradesForUser(Long userId) {
		 List<Trade> transfers = new ArrayList<>();
	        String sql = SQL_SELECT_TRADE + "" +
	                "where (account_from IN (SELECT account_id FROM accounts WHERE user_id = ?) " +
	                "OR account_to IN (SELECT account_id FROM accounts WHERE user_id = ?))";

	        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
	        while(results.next()) {
	            Trade transfer = mapRowToTrade(results);
	            transfers.add(transfer); 
	        }
	        return transfers;
	}
	
	private Long getnextTradeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_trade_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new trade");
		}
	}
	
	private Long getTradeTypeId(String tradeType) {
    	String sql = "SELECT trade_type_id FROM trade_types WHERE trade_type_desc = ?";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tradeType);
    	if(results.next()) {
    		return results.getLong(1);
    	} else {
    		throw new RuntimeException("Unable to lookup trade type "+tradeType);
    	}
    }
    
    private Long getTradeStatusId(String tradeStatus) {
    	String sql = "SELECT trade_status_id FROM trade_statuses WHERE trade_status_desc = ?";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tradeStatus);
    	if(results.next()) {
    		return results.getLong(1);
    	} else {
    		throw new RuntimeException("Unable to lookup trade status "+tradeStatus);
    	}
    }
	
	private Trade mapRowToTrade(SqlRowSet rs) {
		return new Trade(rs.getLong("trade_id"),
				rs.getString("trade_type_desc"),
				rs.getString("trade_status_desc"),
				userDAO.getUserById(rs.getLong("fromUser")),
				userDAO.getUserById(rs.getLong("toUser")),
				rs.getLong("comic_id"));
	}


}
