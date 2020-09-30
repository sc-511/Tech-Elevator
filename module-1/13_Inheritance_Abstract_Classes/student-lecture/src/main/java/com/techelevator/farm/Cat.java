package com.techelevator.farm;

public class Cat extends FarmAnimal {

	private boolean isSleeping = true;
	
	public Cat() {
		
		super("Cat", "Meow!");
		
	}
	
	public void wakeUp() {
		isSleeping = false;
	}
	
	public void goToSleep() {
		isSleeping = true;
	}
	
	@Override
	public String getSound() {
		if (isSleeping) {
			return "Zzzzz...";
		}
		
		return "Meow";
	}

}
