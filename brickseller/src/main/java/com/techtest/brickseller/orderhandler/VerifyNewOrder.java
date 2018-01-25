package com.techtest.brickseller.orderhandler;

import com.techtest.brickseller.objects.OrderRequest;

public class VerifyNewOrder {

	public boolean verififyInput(OrderRequest newOrder) {
		if(newOrder.getUsername() == null || newOrder.getUsername().length() < 5 ||
				newOrder.getAddress() == null ||
				newOrder.getNumberOfBricks() < 1){
			return false;
		} else {
			return true;
		}
	}

}
