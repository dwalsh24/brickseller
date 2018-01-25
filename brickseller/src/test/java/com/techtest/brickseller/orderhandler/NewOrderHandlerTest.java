package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.objects.OrderRequest;
import com.techtest.brickseller.orderhandler.Handler;

public class NewOrderHandlerTest {

	Handler handler;
	OrderRequest orderRequest;
	
	@Before
	public void setUp() throws Exception {
		handler = new Handler();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void verifyHandlerReturnsUniqueReferenceCodeWithValidOrderRequest() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setNumberOfBricks(5);
		String orderReference = handler.newOrderHandler(orderRequest);
		assertNotNull(orderReference);
	}
	
	@Test
	public void verifyHandlerReturnsNullStringWithInvalidOrderRequest(){
		orderRequest = new OrderRequest();
		String orderReference = handler.newOrderHandler(orderRequest);
		assertNull(orderReference);
	}

}
