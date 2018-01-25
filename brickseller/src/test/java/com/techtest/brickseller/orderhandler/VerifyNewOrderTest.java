package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.objects.OrderRequest;
import com.techtest.brickseller.objects.OrderRequestFactory;

public class VerifyNewOrderTest {

	VerifyNewOrder verifier;
	OrderRequest orderRequest;
	OrderRequestFactory orderFactory;
	
	@Before
	public void setUp() throws Exception {
		verifier = new VerifyNewOrder();
		orderFactory = new OrderRequestFactory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void verifyNewOrderVerificationReturnsTrueWithValidInputs() {
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		assertTrue(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithInvalidLengthUsername() {
		orderRequest = orderFactory.createNewOrderRequest("Tes", "Placeton", 5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithNullUsername() {
		orderRequest = orderFactory.createNewOrderRequest(null, "Placeton", 5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithNullAddress() {
		orderRequest = orderFactory.createNewOrderRequest("Tester", null, 5);
		assertFalse(verifier.verififyInput(orderRequest));
	}
	
	@Test
	public void verifyNewOrderVerificationReturnsFalseWithZeroBricks() {
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 0);
		assertFalse(verifier.verififyInput(orderRequest));
	}

}
