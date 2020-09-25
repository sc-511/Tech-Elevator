package com.techelevator;

public class Airplane {

	private String planeNumber;
	private int totalFirstClassSeats;
	private int bookedFirstClassSeats;
	private int totalCoachSeats;
	private int bookedCoachSeats;
	
	public Airplane (String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	
	public int getAvailableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}
	
	public boolean reserveSeats (boolean forFirstClass, int totalNumberOfSeats) {
		
		if (forFirstClass) {
			
			totalNumberOfSeats += bookedFirstClassSeats  ;
			if (totalNumberOfSeats > getAvailableFirstClassSeats()) {
				return false;
			}
			
		}
		
		else	{
			
			totalNumberOfSeats += bookedCoachSeats ;
		
			if (totalNumberOfSeats > getAvailableCoachSeats()) {
				return false;
			
			}
		}
		
		return true;
	}
	
}
