package com.techelevator.crm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PetTests {

	@Test
	public void pet_vaccinations_list_test() {
		List <String> a = new ArrayList <String>();
		
		a.add("jerry");
		a.add("got");
		a.add("rona");
		
		Pet objectToTest = new Pet("", "");
		
		objectToTest.getVaccinations().addAll(a);
		
		
		String holder = objectToTest.listVaccinations();
		Assert.assertEquals("jerry, got, rona", holder);
	}
	
}
