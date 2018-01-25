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
	
	public void removeOrderFromDatabaseByReference(String reference){
		for(AcceptedOrder x: mockDatabase){
			if(x.getReference().equals(reference)){
				mockDatabase.remove(x);
				break;
			}
		}
	}
	
	public void updateShippedStatusByReference(String reference, boolean shippedStatus){
		for(AcceptedOrder x: mockDatabase){
			if(x.getReference().equals(reference)){
				x.setShipped(shippedStatus);
				break;
			}
		}
	}
	
}
