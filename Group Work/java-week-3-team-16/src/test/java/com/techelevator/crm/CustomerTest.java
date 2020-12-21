package com.techelevator.crm;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void test_for_get_balance() {
		
		Map<String, Double> test = new HashMap <String, Double>();
		
		test.put("Neutering", 20.0);
		test.put("Haircut", 80.0);
		test.put("Nail Trimming", 30.0);
		
		Customer objectToTest = new Customer();
		
		Double output = objectToTest.getBalanceDue(test);
		Assert.assertEquals(130.00, output, 0);
	}
	
}
