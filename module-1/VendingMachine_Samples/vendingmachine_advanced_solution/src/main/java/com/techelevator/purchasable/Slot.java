package com.techelevator.purchasable;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

import com.techelevator.MoneyFormatter;

public class Slot {
	private Queue<Purchasable> items;
	private String name;

	/**
	 * Create a named Slot. A Slot holds and distributes Purchasable items in a
	 * first in, first out manner
	 * 
	 * @param name The name for the slot.
	 */
	public Slot(String name) {
		this.name = name;
		this.items = new LinkedList<Purchasable>();
	}

	/**
	 * Add a Purchasable item to the Slot.
	 * 
	 * @param The Purchasable item to add.
	 */
	public void addItem(Purchasable snack) {
		items.add(snack);
	}

	/**
	 * Vend a Purchasable item from the front of the Slot.
	 * 
	 * @return The Purchasable item that is vended.
	 */
	public Purchasable vend() {
		return items.poll();
	}

	/**
	 * Get the quantity of Purchasable in the Slot.
	 * 
	 * @return the quantity of Purchasable in the Slot.
	 */
	public int getQuantity() {
		return items.size();
	}

	/**
	 * Get the name of the Slot.
	 * 
	 * @return The name of the Slot;
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the price of the Purchasable at the front of the Slot.
	 * 
	 * @return The price of the Purchasable at the front of the Slot;
	 */
	public BigDecimal getPrice() {
		return items.peek().getPrice();
	}

	@Override
	public String toString() {
		if (getQuantity() <= 0) {
			return getName() + " Sold Out";
		}

		return getName() + " " + items.peek().getName() + " " + MoneyFormatter.formatMoney(getPrice()) + ", "
				+ getQuantity() + " remaining.";
	}
}
