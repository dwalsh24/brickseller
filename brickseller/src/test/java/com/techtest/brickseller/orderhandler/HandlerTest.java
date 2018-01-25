package com.techtest.brickseller.orderhandler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techtest.brickseller.objects.AcceptedOrder;
import com.techtest.brickseller.objects.OrderRequest;
import com.techtest.brickseller.objects.OrderRequestFactory;
import com.techtest.brickseller.objects.Orders;
import com.techtest.brickseller.orderhandler.Handler;

public class HandlerTest {

	Handler handler;
	OrderRequest orderRequest;
	OrderRequestFactory orderFactory;
	
	@Before
	public void setUp() throws Exception {
		handler = new Handler();
		Handler.orders = new Orders();
		orderFactory = new OrderRequestFactory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void verifyNewOrderHandlerReturnsUniqueReferenceCodeWithValidOrderRequest() {
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
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
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
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
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		AcceptedOrder returnedOrder = handler.getOrderByReference("IncorrectReference");
		assertNull(returnedOrder);
	}
	
	@Test
	public void verifyGetAllOrdersReturnsAllCurrentAcceptedOrders(){
		ArrayList<AcceptedOrder> allOrders;
		OrderRequest orderRequestOne = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String referenceOne = handler.newOrderHandler(orderRequestOne);
		OrderRequest orderRequestTwo = orderFactory.createNewOrderRequest("TesterTwo", "PlacetonTwo", 6);
		String referenceTwo = handler.newOrderHandler(orderRequestTwo);
		OrderRequest orderRequestThree = orderFactory.createNewOrderRequest("TesterThree", "PlacetonThree", 7);
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
	
	@Test
	public void verifyUpdateAcceptedOrderUpdatesOrdersIfReferenceIsValid(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		assertTrue(handler.getOrderByReference(reference).getBricks() == 5);
		assertTrue(handler.getAllOrders().size() == 1);
		
		String updatedReference = handler.updateAcceptedOrder(reference, 7);
		assertNotNull(updatedReference);
		assertNull(handler.getOrderByReference(reference));
		assertTrue(handler.getOrderByReference(updatedReference).getBricks() == 7);
		assertTrue(handler.getAllOrders().size() == 1);
	}
	
	@Test
	public void verifyUpdateAcceptedOrderDoesNotChangeDatabaseIfReferenceIsNotFound(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		assertTrue(handler.getOrderByReference(reference).getBricks() == 5);
		assertTrue(handler.getAllOrders().size() == 1);
		String updatedReference = handler.updateAcceptedOrder("IncorrectReference", 7);
		assertNull(updatedReference);
		assertTrue(handler.getOrderByReference(reference).getBricks() == 5);
		assertTrue(handler.getAllOrders().size() == 1);
	}
	
	@Test
	public void verifyUpdateAcceptedOrderDoesNotChangeDatabaseIfBricksIsLessThanOne(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		assertTrue(handler.getOrderByReference(reference).getBricks() == 5);
		assertTrue(handler.getAllOrders().size() == 1);
		String updatedReference = handler.updateAcceptedOrder("IncorrectReference", 0);
		assertNull(updatedReference);
		assertTrue(handler.getOrderByReference(reference).getBricks() == 5);
		assertTrue(handler.getAllOrders().size() == 1);
	}
	
	@Test
	public void verifyFulfilOrderByReferenceUpdatesShippingStatusWithValidReference(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		AcceptedOrder acceptedOrder = handler.getOrderByReference(reference);
		assertTrue(acceptedOrder.getShipped() == false);
		
		String response = handler.fulfilOrderByReference(reference);
		acceptedOrder = handler.getOrderByReference(reference);
		assertTrue(response.equals("Set shipped status to true"));
		assertTrue(acceptedOrder.getShipped() == true);
	}
	
	@Test
	public void verifyFulfilOrderByReferenceReturns400ErrorWithInvalidReference(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		AcceptedOrder acceptedOrder = handler.getOrderByReference(reference);
		assertTrue(acceptedOrder.getShipped() == false);
		
		String response = handler.fulfilOrderByReference("Invalid reference");
		acceptedOrder = handler.getOrderByReference(reference);
		assertTrue(response.equals("400 Error: Bad Request"));
		assertTrue(acceptedOrder.getShipped() == false);
	}
	
	@Test
	public void verifyUpdateAcceptedOrderReturns400ErrorShippedEqualsTrue(){
		orderRequest = orderFactory.createNewOrderRequest("Tester", "Placeton", 5);
		String reference = handler.newOrderHandler(orderRequest);
		handler.fulfilOrderByReference(reference);
		String response = handler.updateAcceptedOrder(reference, 7);
		assertTrue(response.equals("400 Error: Bad Request"));
	}

}
