package com.techelevator;

public class Television {

	private boolean isOn = false;
	
	private int currentChannel = 3 ;
	
	private int currentVolume = 2;
	
	public Television () {}
	
	public boolean isOn() {
		
		return isOn;
	}
	
	public int getCurrentChannel() {
		
		return currentChannel;
	}
	
	public int getCurrentVolume() {
		
		return currentVolume;
	}
	
	public void turnOff() {
		
		isOn = false;
	
	
}

	public void turnOn() {
		
		isOn = true;
		
		currentChannel = 3;
		
		currentVolume = 2;
		
	}
	
	public void changeChannel(int newChannel) {
		
		if (isOn == true){
			
			if (newChannel >= 3 && newChannel <= 18) {
				
				currentChannel = newChannel;
			}
			
			else {
				
				currentChannel = 3;
			}
		}
		
		else {
			
			isOn = false;
		}
		
	}
	
	public void channelUp() {
		if (isOn == true) {
		
			if (currentChannel == 18) {
				
				currentChannel = 3;
			}
			
			else {
				
				currentChannel += 1;
			}
		}
		
		else {
				
			isOn = false;
			
			}
	}
	
	public void channelDown() {
		if (isOn == true) {
			
			if (currentChannel == 3) {
				
				currentChannel = 18;
			}
			
			else {
				
				currentChannel -= 1;
			}
		}
		
		else {
				
			isOn = false;
			
			}
	}
	
	
	
	public void raiseVolume() {
		
		if (isOn == true) {
			
			if (!(currentVolume == 10)) {
				
				currentVolume += 1;
			}
			
			else {
				
				currentVolume += 0;
			}
		}
		
		else {
			
			isOn = false;
		}
		
	}
	
	public void lowerVolume() {
		
		if (isOn == true) {
			
			if (!(currentVolume == 0)) {
				
				currentVolume -= 1;
			}
			
			else {
				currentVolume -= 0;
			}
		}
		
		else {
			
			isOn = false;
		}
		
	}
	
}
	
	
	
	
	