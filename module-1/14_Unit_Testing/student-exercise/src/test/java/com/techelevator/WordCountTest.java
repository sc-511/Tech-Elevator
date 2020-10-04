package com.techelevator;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	
	@Test
	public void getCount_should_return__two_two_one () {
		
		WordCount a = new WordCount();
		Map<String,Integer> holder = a.getCount(new String[] {"ba", "ba", "black", "sheep"});
		holder.put("ba", 2);
		holder.put("black", 1);
		holder.put("sheep", 1);
		
		Map<String, Integer> actual = a.getCount(new String[] {"ba", "ba", "black", "sheep"});
		Assert.assertEquals(actual, holder);
	}
	
	@Test
	public void getCount_should_return__two_one_one () {
		
		WordCount a = new WordCount();
		Map<String,Integer> holder = a.getCount(new String[] {"a", "b", "a", "c", "b"});
		holder.put("a", 2);
		holder.put("b", 2);
		holder.put("c", 1); 
		
		Map<String,Integer> actual = a.getCount(new String[] {"a", "a", "b", "b", "c"} );
		Assert.assertEquals(actual, holder);
	}
	
	@Test
	public void getCount_should_return__blank () {
		
		WordCount a = new WordCount();
		Map<String,Integer> holder = a.getCount(null);
		assertEquals(new HashMap <String, Integer> (), holder);
	}
	
	@Test
	public void getCount_should_return__one_one_one () {
		
		WordCount a = new WordCount();
		Map<String,Integer> holder = a.getCount(new String[] {"c", "b", "a"});
		holder.put("a", 1);
		holder.put("b", 1);
		holder.put("c", 1);
		
		Map<String, Integer> actual = a.getCount(new String[] {"c", "b", "a"});
		Assert.assertEquals(actual, holder);
		
	}
}
