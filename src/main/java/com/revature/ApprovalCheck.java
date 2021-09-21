package com.revature;

public class ApprovalCheck {
	private String Username;
	private boolean IsApproved;
	
	public boolean approvalCheck(boolean isApproved) {
		// TODO Auto-generated constructor stub
		return isApproved;
	}
	
	public ApprovalCheck(String username, boolean isApproved) {
		this.Username = username;
		this.IsApproved = isApproved;
	}
	
	public ApprovalCheck(boolean isApproved) {
		this.IsApproved = isApproved;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public boolean getIsApproved() {
		return IsApproved;
	}
	public void setIsApproved(boolean isApproved) {
		IsApproved = isApproved;
	}
	
}
