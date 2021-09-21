package com.revature;

public class ApproveAccount {

	private String username;
	private boolean isApproved;
	
	public ApproveAccount(String username, boolean isApproved) {
		this.username = username;
		this.isApproved = isApproved;
	}
	
	public ApproveAccount(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
