package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SameFirstLastTest {

	@Test
	public void first_last_not_same_array () {
		SameFirstLast a = new SameFirstLast();
		boolean placeHolder = a.isItTheSame(new int[] {1, 2, 3});
		
		Assert.assertEquals(false, placeHolder);
	}
	
	@Test
	public void first_last_is_same_array () {
		SameFirstLast a = new SameFirstLast();
		boolean placeHolder = a.isItTheSame(new int[] {1, 2, 3, 1});
		
		Assert.assertEquals(true, placeHolder);
	}
	
	@Test
	public void first_last_is_same_diff_length () {
		SameFirstLast a = new SameFirstLast();
		boolean placeHolder = a.isItTheSame(new int[] {1, 2, 1});
		
		Assert.assertEquals(true, placeHolder);
	}
}
