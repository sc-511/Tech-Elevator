package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {
	
	@Test
	public void below_condition_not_weekend () {
		
		CigarParty condition = new CigarParty ();
		boolean holder = condition.haveParty(30, false);
		Assert.assertEquals(false, holder);
	}
	
	@Test
	public void in_condition_not_weekend () {
		
		CigarParty condition = new CigarParty ();
		boolean holder = condition.haveParty(50, false);
		Assert.assertEquals(true, holder);
	}
	
	@Test
	public void above_condition_is_weekend () {
		
		CigarParty condition = new CigarParty ();
		boolean holder = condition.haveParty(70, true);
		Assert.assertEquals(true, holder);
	}
}
