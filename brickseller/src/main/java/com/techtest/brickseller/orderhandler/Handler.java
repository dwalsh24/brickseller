package com.techtest.brickseller.orderhandler;

import com.google.gson.JsonObject;
import com.techtest.brickseller.objects.OrderRequest;

public class Handler {

	GenerateOrderReference generateOrderReference;
	VerifyNewOrder verifier;
	
	public String newOrderHandler(OrderRequest newOrder){
		verifier = new VerifyNewOrder();
		generateOrderReference = new GenerateOrderReference();
		String orderReference;
		
		if(!verifier.verififyInput(newOrder)){
			return null;
		}
		
		orderReference = generateOrderReference.generateReference(newOrder.getUsername());
		return orderReference;
	}

}
