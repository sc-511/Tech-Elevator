package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {
	
	private AnimalGroupName a;
	
	@Before
	public void new_object_please() {
		a = new AnimalGroupName();
	}

	@Test
	public void test_test() {
		AnimalGroupName a = new AnimalGroupName(); //Arrange
		String input = "giraffe";
		
		String output = a.getHerd(input);//Act
		
		Assert.assertEquals("Tower", output);//Assert
	}
	
	@Test
	public void empty_is_unknown() {
		
		AnimalGroupName a = new AnimalGroupName();
		String input = "";
		String output = a.getHerd(input);
		Assert.assertEquals("unknown", output);
	}
	
	@Test 
	public void not_in_hashmap () {
		
		AnimalGroupName a = new AnimalGroupName();
		String input = "walrus";
		String output = a.getHerd(input);
		Assert.assertEquals("unknown", output);
	}
	
	@Test
	public void first_char_capitalized () {
		AnimalGroupName a = new AnimalGroupName();
		String input = "Rhino";
		String output = a.getHerd(input);
		Assert.assertEquals("Crash", output);
	}
	
	@Test
	public void all_char_lower() {
		AnimalGroupName a = new AnimalGroupName();
		String input = "rhino";
		String output = a.getHerd(input);
		Assert.assertEquals("Crash", output);
	}
	
	public void animal_not_in_hashmap () {
		AnimalGroupName a = new AnimalGroupName();
		String input = "elephants";
		String output = a.getHerd(input);
		Assert.assertEquals("unknown", output);
	}
	
	
}
