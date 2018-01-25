package com.techtest.brickseller.objects;

public class AcceptedOrder {
	private String reference;
	private String username;
	private String address;
	private int bricks;
	private boolean shipped;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBricks() {
		return bricks;
	}
	public void setBricks(int bricks) {
		this.bricks = bricks;
	}
	public boolean getShipped() {
		return shipped;
	}
	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

}
