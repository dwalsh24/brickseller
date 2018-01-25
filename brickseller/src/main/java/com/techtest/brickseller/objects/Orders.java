package com.techtest.brickseller.objects;

import java.util.ArrayList;

public class Orders {

	private ArrayList<AcceptedOrder> mockDatabase = null;

	public ArrayList<AcceptedOrder> getMockDatabase() {
		return mockDatabase;
	}

	public void setMockDatabase(ArrayList<AcceptedOrder> mockDatabase) {
		this.mockDatabase = mockDatabase;
	}
	
}
