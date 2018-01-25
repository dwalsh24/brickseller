package com.techtest.brickseller.orderhandler;

public class GenerateOrderReference {

	//Lower limit of username length 5
	public String generateReference(String username){
		if(username.length() < 5){
			return null;
		}
		String trueUniqueEnd = System.nanoTime() + "";
		String orderReference = username.substring(0,3).toUpperCase() + System.currentTimeMillis() + trueUniqueEnd.substring(5);
		System.out.println("Order reference: " + orderReference);
		return orderReference;
	}
}
