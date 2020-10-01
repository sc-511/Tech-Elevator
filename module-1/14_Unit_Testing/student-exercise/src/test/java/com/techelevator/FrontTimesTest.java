package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {
	
	@Test
	public void return_two_copies_of_first_three_char () {
		FrontTimes a = new FrontTimes();
		String holder = a.generateString("Chocolate", 2);
		Assert.assertEquals("ChoCho", holder);
	}
	
	@Test
	public void return_three_copies_of_first_three_char () {
		FrontTimes a = new FrontTimes();
		String holder = a.generateString("Chocolate", 3);
		Assert.assertEquals("ChoChoCho", holder);
	}
	
	@Test
	public void return_three_copies_of_three_letter_char () {
		FrontTimes a = new FrontTimes();
		String holder = a.generateString("Abc", 3);
		Assert.assertEquals("AbcAbcAbc", holder);
	}
}
