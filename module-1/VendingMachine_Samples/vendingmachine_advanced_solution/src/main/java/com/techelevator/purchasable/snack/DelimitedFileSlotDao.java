package com.techelevator.purchasable.snack;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.purchasable.Slot;
import com.techelevator.purchasable.SlotDao;

public class DelimitedFileSlotDao implements SlotDao {
	private final File inventoryFile;
	private static final int DEFAULT_QUANTITY = 5;
	
	public DelimitedFileSlotDao(File inventoryFile) {
		this.inventoryFile = inventoryFile;
		
		if(inventoryFile == null) {
			throw new IllegalArgumentException("inventoryFile cannot be null");
		}
	}
	
	@Override
	public Map<String, Slot> getAllSlots() {
		Map<String, Slot> slots =  new LinkedHashMap<>();
		
		try (Scanner fileScanner = new Scanner(inventoryFile)) {
			int lineCounter = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lineCounter++;
				String[] lineParts = line.split("\\|");

				if (lineParts.length < 4 || lineParts[2] == null) {
					throw new IllegalArgumentException("Invalid file format on line " + lineCounter);
				}

				String slotName = lineParts[0];
				String snackName = lineParts[1];
				double snackPrice = Double.parseDouble(lineParts[2]);
				String snackType = lineParts[3];

				Snack snack = Snack.createSnackForType(snackType, snackName, BigDecimal.valueOf(snackPrice));

				Slot theSlot;
				if(slots.containsKey(slotName)) {
					theSlot = slots.get(slotName);
				} else {
					theSlot = new Slot(slotName);
					slots.put(slotName, theSlot);
				}
				
				// add the Snack to the Slot in the quantity expected.
				for(int i = 1; i <= DEFAULT_QUANTITY; i++) {
					theSlot.addItem(snack);	
				}
			}
		} catch (FileNotFoundException e) {
			return null;
		}
		
		return slots;
	}

}
