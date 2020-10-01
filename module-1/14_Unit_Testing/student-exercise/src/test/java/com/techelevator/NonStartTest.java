package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {
	
	@Test
	public void should_return_ellohere_after_concatination () {
		NonStart a = new NonStart();
		String holder = a.getPartialString("Hello", "There");
		Assert.assertEquals("ellohere", holder);
	}
	
	@Test
	public void should_return_avaode_after_concatination () {
		NonStart a = new NonStart();
		String holder = a.getPartialString("java", "code");
		Assert.assertEquals("avaode", holder);
	}
	
	@Test
	public void should_return_hotlava_after_concatination() {
		NonStart a = new NonStart();
		String holder = a.getPartialString("shotl", "java");
		Assert.assertEquals("hotlava", holder);
	}
}
