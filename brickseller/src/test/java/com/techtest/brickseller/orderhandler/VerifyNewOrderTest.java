package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.objects.OrderRequest;

public class VerifyNewOrderTest {

	VerifyNewOrder verifier;
	OrderRequest orderRequest;
	
	@Before
	public void setUp() throws Exception {
		verifier = new VerifyNewOrder();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void verifyNewOrderVerificationReturnsTrueWithValidInputs() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		assertTrue(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithInvalidLengthUsername() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tes");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithNullUsername() {
		orderRequest = new OrderRequest();
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithNullAddress() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setBricks(5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithZeroBricks() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(0);
		assertFalse(verifier.verififyInput(orderRequest));
	}

}
