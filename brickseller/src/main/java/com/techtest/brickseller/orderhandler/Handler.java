package com.techtest.brickseller.orderhandler;

import java.util.ArrayList;

import com.techtest.brickseller.objects.AcceptedOrder;
import com.techtest.brickseller.objects.AcceptedOrderFactory;
import com.techtest.brickseller.objects.OrderRequest;
import com.techtest.brickseller.objects.Orders;

public class Handler {

	static Orders orders = new Orders();
	GenerateOrderReference generateOrderReference;
	VerifyNewOrder verifier;
	AcceptedOrderFactory acceptedOrderFactory;
	
	public String newOrderHandler(OrderRequest newOrder){
		verifier = new VerifyNewOrder();
		generateOrderReference = new GenerateOrderReference();
		acceptedOrderFactory = new AcceptedOrderFactory();
		String orderReference;
		
		if(!verifier.verififyInput(newOrder)){
			return null;
		}
		
		orderReference = generateOrderReference.generateReference(newOrder.getUsername());
		orders.addOrderToMockDatabase(acceptedOrderFactory.createAcceptedOrder(orderReference, newOrder.getUsername(), newOrder.getAddress(), newOrder.getBricks(), false));
		return orderReference;
	}
	
	public AcceptedOrder getOrderByReference(String reference){
		ArrayList<AcceptedOrder> currentOrders = orders.getMockDatabase();
		AcceptedOrder matchedOrder = null;
		for(AcceptedOrder x: currentOrders){
			if(x.getReference().equals(reference)){
				matchedOrder = x;
				break;
			}
		}
		return matchedOrder;
	}
	
	public ArrayList<AcceptedOrder> getAllOrders(){
		return orders.getMockDatabase();
	}

}
