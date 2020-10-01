package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {
	
	@Test
	public void one_stylish_guest () {
		DateFashion a = new DateFashion ();
		int output = a.getATable(5, 10);
		Assert.assertEquals(2, output);
	}
	
	@Test
	public void one_guest_with_under_two () {
		DateFashion a = new DateFashion ();
		int output = a.getATable(5, 2);
		Assert.assertEquals(0, output);
	}
	
	@Test
	public void higher_than_two_points_stylish_guest_but_less_than_eight () {
		DateFashion a = new DateFashion ();
		int output = a.getATable(5, 5);
		Assert.assertEquals(1, output);
	}
}
