package com.techelevator.purchasable.snack;

import java.io.File;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.purchasable.Slot;
import com.techelevator.purchasable.snack.DelimitedFileSlotDao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DelimitedFileSlotDaoTests {

	@Test(expected = IllegalArgumentException.class)
	public void create_with_null_file_throws() {
		new DelimitedFileSlotDao(null);
	}

	@Test
	public void getAllSlots_with_invalid_file_returns_no_stock() {
		// Arrange
		DelimitedFileSlotDao slotDao = new DelimitedFileSlotDao(new File(""));

		// Act
		Map<String, Slot> slots = slotDao.getAllSlots();
		
		// Assert
		Assert.assertNull(slots);
	}

	@Test
	public void restock_vending_machine_adds_16_items() {
		// Arrange
		DelimitedFileSlotDao slotDao = new DelimitedFileSlotDao(new File("vendingmachine.csv"));

		// Act
		Map<String, Slot> slots = slotDao.getAllSlots();

		// Assert
		Assert.assertNotNull(slots);
		Assert.assertEquals(16, slots.size());
	}
	
	@Test
	public void restock_vending_machine_adds_5_for_each_item() {
		// Arrange
		DelimitedFileSlotDao slotDao = new DelimitedFileSlotDao(new File("vendingmachine.csv"));

		// Act
		Map<String, Slot> slots = slotDao.getAllSlots();

		// Assert
		Assert.assertNotNull(slots);
		for(String slotName : slots.keySet()) {
			Assert.assertEquals(5, slots.get(slotName).getQuantity());
		}
	}
}
