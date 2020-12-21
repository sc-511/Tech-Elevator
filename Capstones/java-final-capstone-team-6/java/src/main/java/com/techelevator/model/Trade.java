package com.techelevator.model;

import java.math.BigDecimal;
import java.util.Objects;





public class Trade {
	private Long tradeId;
	private String tradeType;
	private String tradeStatus;
	private User userFrom;
	private User userTo;
	private Long comicId;
	
	public static final String TRADE_TYPE_REQUEST = "Request";
    public static final String TRADE_TYPE_SEND = "Send";
    public static final String TRADE_STATUS_PENDING = "Pending";
    public static final String TRADE_STATUS_APPROVED = "Approved";
    public static final String TRADE_STATUS_REJECTED = "Rejected";
	
    public Trade(String tradeType, User userFrom, User userTo, Long comicId) {
    	this(null, tradeType, getInitialStatusForTransferType(tradeType), userFrom, userTo, comicId);
    }
    
	public Trade(Long tradeId, String tradeType, String tradeStatus, User userFrom, User userTo, Long comicId) {
		this.tradeId = tradeId;
		this.tradeType= tradeType;
		this.tradeStatus = tradeStatus;
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.comicId = comicId;
	}
	public Trade () {
		
	}
	public Long getTradeId() {
		return tradeId;
	}
	
	public String getTradeType() {
		return tradeType;
	}
	
	
	public String getTradeStatus() {
		return tradeStatus;
	}
	
	public User getUserFrom() {
		return userFrom;
	}
	
	public User getUserTo() {
		return userTo;
	}
	
	public Long getComicId() {
		return comicId;
	}
	
	public boolean isApproved() {
		return TRADE_STATUS_APPROVED.equals(this.tradeStatus);
	}
	
	public boolean isRejected() {
		return TRADE_STATUS_REJECTED.equals(this.tradeStatus);
	}
	
	public boolean isPending() {
		return TRADE_STATUS_PENDING.equals(this.tradeStatus);
	}
	
	public boolean isRequestType() {
		return TRADE_TYPE_REQUEST.equals(this.tradeType);
	}
	
	public boolean isSendType() {
		return TRADE_TYPE_SEND.equals(this.tradeType);
	}

	public void approve() throws InvalidTradeStatusUpdateException {
		if(isPending()) {
			// only pending transfers can be approved
			tradeStatus = TRADE_STATUS_APPROVED;
		} else {
			throw new InvalidTradeStatusUpdateException(tradeStatus, TRADE_STATUS_APPROVED);
		}
	}

	public void reject() {
		if(isPending()) {
			// only pending transfers can be rejected
			tradeStatus = TRADE_STATUS_REJECTED;
		} else {
			throw new InvalidTradeStatusUpdateException(tradeStatus, TRADE_STATUS_REJECTED);
		}
	}

    private void validateTransferType() {
    	if(!(TRADE_TYPE_REQUEST.equals(tradeType) || TRADE_TYPE_SEND.equals(tradeType))) {
    		throw new IllegalArgumentException(tradeType + " is not a valid transferType");
    	}
    }

    private void validateTransferStatus() {
    	if(!(TRADE_STATUS_APPROVED.equals(tradeStatus) || TRADE_STATUS_PENDING.equals(tradeStatus) || TRADE_STATUS_REJECTED.equals(tradeStatus))) {
    		throw new IllegalArgumentException(tradeStatus + " is not a valid transferStatus");
    	}
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equals(tradeId, trade.tradeId) &&
                Objects.equals(tradeType, trade.tradeType) &&
                tradeStatus == trade.tradeStatus &&
                Objects.equals(userFrom, trade.userFrom) &&
                Objects.equals(userTo, trade.userTo) &&
                Objects.equals(comicId, trade.comicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId, tradeType, tradeStatus, userFrom, userTo, comicId);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeType=" + tradeType +
                ", tradeStatus=" + tradeStatus +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", comicId=" + comicId +
                '}';
    }
    
	private static String getInitialStatusForTransferType(String tradeType) {
		String tradeStatus = null;
    	if(Trade.TRADE_TYPE_REQUEST.equals(tradeType)) {
    		tradeStatus = Trade.TRADE_STATUS_PENDING;
    	} else if(Trade.TRADE_TYPE_SEND.equals(tradeType)) {
    		tradeStatus = Trade.TRADE_STATUS_APPROVED;
    	}
		return tradeStatus;
	}
	
	
}
