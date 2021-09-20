package com.revature;

public class employeeToDo {
	private int customer_ID;
	private String username;
	private String password;
	boolean isApproved;
	private String Firstname;
	private String Lastname;
	
	public employeeToDo(int customer_ID, String username, String password, boolean isApproved) {
		this.customer_ID = customer_ID;
		this.username = username;
		this.password = password;
		this.isApproved = isApproved;
	}
	
	public employeeToDo(String username, String password, boolean isApproved) {
		this.username = username;
		this.password = password;
		this.isApproved = isApproved;
	}
	
	public employeeToDo(String username, boolean isApproved) {
		this.username = username;
		this.isApproved = isApproved;
	}
	
	public employeeToDo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}
	
	public String getFirstname() {
		return Firstname;
	}
	
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	
	public String getLastname() {
		return Lastname;
	}
	
	public int getCustomer_ID() {
		return customer_ID;
	}
	
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public boolean getIsApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
	

}
