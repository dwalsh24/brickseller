package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.orderhandler.GenerateOrderReference;

public class GenerateOrderReferenceTest {

	GenerateOrderReference generateOrderReference;
	
	@Before
	public void setUp() throws Exception {
		generateOrderReference = new GenerateOrderReference();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void verifyMethodDoesNotReturnNullWhenGivenValidEntries() {
		String returnValue = generateOrderReference.generateReference("Tester");
		assertNotNull(returnValue);
	}
	
	@Test
	public void verifyMethodReturnsUniqueReferences(){
		String referenceOne = generateOrderReference.generateReference("Tester");
		String referenceTwo = generateOrderReference.generateReference("Testers");
		assertFalse(referenceOne.equals(referenceTwo));
	}
	
	@Test
	public void verifyNullReturnedIfUsernameLessThan5Characters(){
		String returnValue = generateOrderReference.generateReference("Tes");
		assertNull(returnValue);
	}

}
