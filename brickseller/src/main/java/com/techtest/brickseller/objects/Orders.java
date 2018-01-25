package com.techtest.brickseller.objects;

import java.util.ArrayList;

public class Orders {

	private ArrayList<AcceptedOrder> mockDatabase = new ArrayList<AcceptedOrder>();

	public ArrayList<AcceptedOrder> getMockDatabase() {
		return mockDatabase;
	}

	public void setMockDatabase(ArrayList<AcceptedOrder> mockDatabase) {
		this.mockDatabase = mockDatabase;
	}
	
	public void addOrderToMockDatabase(AcceptedOrder order){
		mockDatabase.add(order);
	}
	
}
