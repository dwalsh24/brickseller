package com.techtest.brickseller.objects;

public class OrderRequest {

	private String username;
	private String address;
	private int bricks;

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

}
