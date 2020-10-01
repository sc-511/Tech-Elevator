package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {
	
	@Test
	public void no_ones_no_threes () {
		Lucky13 a = new Lucky13 ();
		boolean holder = a.getLucky(new int[] {0,2, 4});
		Assert.assertEquals(true, holder);
	}
	
	@Test
	public void one_and_three() {
		Lucky13 a = new Lucky13 ();
		boolean holder = a.getLucky(new int[] {1,2, 3});
		Assert.assertEquals(false, holder);
	}
	
	@Test
	public void one_only() {
		Lucky13 a = new Lucky13 ();
		boolean holder = a.getLucky(new int[] {1,2, 4});
		Assert.assertEquals(false, holder);
	}
	
}
