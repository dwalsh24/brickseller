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
	public int getBricks() {
		return bricks;
	}
	public void setBricks(int bricks) {
		this.bricks = bricks;
	}
	public boolean isShipped() {
		return shipped;
	}
	public void setShipped(boolean shipped) {
		this.shipped = shipped;
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
	public String getPostcode() {
		return address;
	}
	public void setPostcode(String postcode) {
		this.address = postcode;
	}
	public int getNumberOfBricks() {
		return bricks;
	}
	public void setNumberOfBricks(int numberOfBricks) {
		this.bricks = numberOfBricks;
	}
}
