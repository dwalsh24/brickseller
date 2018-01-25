package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.objects.AcceptedOrder;
import com.techtest.brickseller.objects.OrderRequest;
import com.techtest.brickseller.objects.Orders;
import com.techtest.brickseller.orderhandler.Handler;

public class HandlerTest {

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
	public void verifyNewOrderHandlerReturnsUniqueReferenceCodeWithValidOrderRequest() {
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		String orderReference = handler.newOrderHandler(orderRequest);
		assertNotNull(orderReference);
	}
	
	@Test
	public void verifyNewOrderHandlerReturnsNullStringWithInvalidOrderRequest(){
		orderRequest = new OrderRequest();
		String orderReference = handler.newOrderHandler(orderRequest);
		assertNull(orderReference);
	}
	
	@Test
	public void verifyGetOrderByReferenceReturnsCorrectOrderWithReference(){
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		String reference = handler.newOrderHandler(orderRequest);
		AcceptedOrder returnedOrder = handler.getOrderByReference(reference);
		assertTrue(returnedOrder.getUsername().equals("Tester"));
		assertTrue(returnedOrder.getAddress().equals("Placeton"));
		assertTrue(returnedOrder.getBricks() == 5);
		assertTrue(returnedOrder.getReference().equals(reference));
		assertTrue(returnedOrder.getShipped() == false);
	}
	
	@Test
	public void verifyGetOrderByReferenceReturnsNullWithIncorrectReference(){
		orderRequest = new OrderRequest();
		orderRequest.setUsername("Tester");
		orderRequest.setAddress("Placeton");
		orderRequest.setBricks(5);
		AcceptedOrder returnedOrder = handler.getOrderByReference("IncorrectReference");
		assertNull(returnedOrder);
	}
	
	@Test
	public void verifyGetAllOrdersReturnsAllCurrentAcceptedOrders(){
		Handler.orders = new Orders();
		ArrayList<AcceptedOrder> allOrders;
		OrderRequest orderRequestOne = new OrderRequest();
		orderRequestOne.setUsername("Tester");
		orderRequestOne.setAddress("Placeton");
		orderRequestOne.setBricks(5);
		String referenceOne = handler.newOrderHandler(orderRequestOne);
		OrderRequest orderRequestTwo = new OrderRequest();
		orderRequestTwo.setUsername("TesterTwo");
		orderRequestTwo.setAddress("PlacetonTwo");
		orderRequestTwo.setBricks(6);
		String referenceTwo = handler.newOrderHandler(orderRequestTwo);
		OrderRequest orderRequestThree = new OrderRequest();
		orderRequestThree.setUsername("TesterThree");
		orderRequestThree.setAddress("PlacetonThree");
		orderRequestThree.setBricks(7);
		String referenceThree = handler.newOrderHandler(orderRequestThree);
		allOrders = handler.getAllOrders();
		
		assertTrue(allOrders.get(0).getUsername().equals("Tester"));
		assertTrue(allOrders.get(0).getAddress().equals("Placeton"));
		assertTrue(allOrders.get(0).getBricks() == 5);
		assertTrue(allOrders.get(0).getReference().equals(referenceOne));
		assertTrue(allOrders.get(0).getShipped() == false);
		
		assertTrue(allOrders.get(1).getUsername().equals("TesterTwo"));
		assertTrue(allOrders.get(1).getAddress().equals("PlacetonTwo"));
		assertTrue(allOrders.get(1).getBricks() == 6);
		assertTrue(allOrders.get(1).getReference().equals(referenceTwo));
		assertTrue(allOrders.get(1).getShipped() == false);
		
		assertTrue(allOrders.get(2).getUsername().equals("TesterThree"));
		assertTrue(allOrders.get(2).getAddress().equals("PlacetonThree"));
		assertTrue(allOrders.get(2).getBricks() == 7);
		assertTrue(allOrders.get(2).getReference().equals(referenceThree));
		assertTrue(allOrders.get(2).getShipped() == false);
	}

}