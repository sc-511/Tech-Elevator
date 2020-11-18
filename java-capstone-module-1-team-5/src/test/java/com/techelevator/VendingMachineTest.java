package com.techelevator;

import org.junit.Test;
import org.junit.Assert;

public class VendingMachineTest {

	@Test
	public void testingGiveChangeWithOutOfBoundsNums () {
		VendingMachine testVariable = new VendingMachine ();
		double inputVariable = testVariable.GiveChange(-1);
		Assert.assertEquals(testVariable.getTotalFeedCount(), inputVariable, 0);
		
	}
	
	@Test
	public void testing_Give_Change_With_Bounds_Nums() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = 1;
		double inputVariable = testVariable.GiveChange(totalFeedCount);
		Assert.assertEquals(testVariable.getTotalFeedCount() , inputVariable, 0);
	}
	
	@Test
	public void testing_feed_money_else_statement() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = 3;
		double inputVariable = testVariable.feedMoney(totalFeedCount);
		Assert.assertEquals(0, inputVariable, 0);
	}
	
	
	@Test
	public void testing_Give_Change_With_decimals() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = 5.50;
		double inputVariable = testVariable.GiveChange(totalFeedCount);
		Assert.assertEquals(0, inputVariable, 0);
		Assert.assertEquals( 22, testVariable.getNumQuarters(), 0);
		
	}
	
	@Test
	public void testing_Give_Change_With_Dimes() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = .10;
		double inputVariable = testVariable.GiveChange(totalFeedCount);
		Assert.assertEquals(1, testVariable.getNumDimes(), 0 );
	}
	
	@Test
	public void testing_Give_Change_With_Nickels() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = .05;
		double inputVariable = testVariable.GiveChange(totalFeedCount);
		Assert.assertEquals(1, testVariable.getNumNickels(), 0 );
	}
	
	@Test
	public void testing_Give_Change_With_negative_decimals() {
		VendingMachine testVariable = new VendingMachine();
		double totalFeedCount = -5.50;
		double inputVariable = testVariable.GiveChange(totalFeedCount);
		Assert.assertEquals(testVariable.getTotalFeedCount(), inputVariable, 0);
	}
	
	@Test
	public void testing_FeedMoney_With_Out_Of_Bounds_Nums () {
		VendingMachine testVariable = new VendingMachine();
		double inputVariable = testVariable.feedMoney(10);
		Assert.assertEquals(testVariable.getTotalFeedCount(), inputVariable, 0);
	}
	
	@Test
	public void testing_deduct_balance () {
		VendingMachine testVariable = new VendingMachine ();
		double inputVariable = testVariable.deductBalance(100);
		Assert.assertEquals(-100, inputVariable, 0);
	}
	
	@Test
	public void testing_deduct_Item_Quantity () {
		VendingMachine testVariable = new VendingMachine ();
		int inputVariable = testVariable.deductItemQuantity("A1");
		Assert.assertEquals(4 , inputVariable);
	}
		
	
	
}
