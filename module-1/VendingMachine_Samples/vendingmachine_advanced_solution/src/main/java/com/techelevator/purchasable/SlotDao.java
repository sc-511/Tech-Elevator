package com.techelevator.purchasable;

import java.util.Map;

public interface SlotDao {
	
	/**
	 * Get a Map of named keys to Slot values from a data store.
	 * 
	 * @return A Map of slot name keys to Slot values.
	 */
	public Map<String, Slot> getAllSlots();
}
