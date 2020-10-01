package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {
	
	@Test
	public void last_element_is_largest () {
		MaxEnd3 a = new MaxEnd3();
		int[] placeHolder = a.makeArray(new int[] {1, 2, 3});
		
		Assert.assertArrayEquals(new int[]{3, 3, 3}, placeHolder);
	}
	
	@Test
	public void first_element_is_largest () {
		MaxEnd3 a = new MaxEnd3();
		int[] placeHolder = a.makeArray(new int[] {11, 5, 9});
		
		Assert.assertArrayEquals(new int[]{11, 11, 11}, placeHolder);
	}
	
	@Test
	public void last_element_is_largest_even_with_higher_middle_element () {
		MaxEnd3 a = new MaxEnd3();
		int[] placeHolder = a.makeArray(new int[] {2, 11, 3});
		
		Assert.assertArrayEquals(new int[]{3,3,3}, placeHolder);
	}
	
}
