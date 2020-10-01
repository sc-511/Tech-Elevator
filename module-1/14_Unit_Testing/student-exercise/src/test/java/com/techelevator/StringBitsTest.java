package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {

	@Test
	public void should_return_Hlo_after_taking_every_other_char () {
		StringBits a = new StringBits();
		String holder = a.getBits("Hello");
		Assert.assertEquals("Hlo", holder);
	}
	
	
	@Test
	public void should_return_H_after_taking_every_other_char () {
		StringBits a = new StringBits();
		String holder = a.getBits("Hi");
		Assert.assertEquals("H", holder);
	}
	
	@Test
	public void should_return_Hello_after_taking_every_other_char() {
		StringBits a = new StringBits();
		String holder = a.getBits("Heeololeo");
		Assert.assertEquals("Hello", holder);
	}
	
}
