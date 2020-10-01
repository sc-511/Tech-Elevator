package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {
	
	@Test
	public void two_less_than_multiple_of_forty (){
		Less20 a = new Less20 ();
		boolean holder = a.isLessThanMultipleOf20(18);
		Assert.assertEquals(true, holder);
	}
	
	@Test
	public void one_less_than_multiple_of_forty (){
		Less20 a = new Less20 ();
		boolean holder = a.isLessThanMultipleOf20(18);
		Assert.assertEquals(true, holder);
	}
	
	@Test
	public void higher_than_thirty_nine (){
		Less20 a = new Less20 ();
		boolean holder = a.isLessThanMultipleOf20(20);
		Assert.assertEquals(false, holder);
	}
	
}
