package com.techtest.brickseller.objects;

public class OrderRequestFactory {

	public OrderRequest createNewOrderRequest(String username, String address, int bricks){
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setUsername(username);
		orderRequest.setAddress(address);
		orderRequest.setBricks(bricks);
		return orderRequest;
	}
}
