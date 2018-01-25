package com.techtest.brickseller.objects;

public class AcceptedOrderFactory {

	public AcceptedOrder createAcceptedOrder(String reference, String username, String address, int bricks, boolean shipped){
		AcceptedOrder order = new AcceptedOrder();
		order.setReference(reference);
		order.setUsername(username);
		order.setAddress(address);
		order.setBricks(bricks);
		order.setShipped(shipped);
		
		return order;
	}
}
