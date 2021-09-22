package com.revature;

public class CustomerToDo {
	private double checkingAcctBalance;
	private double savingsAcctBalance;
//	private double checkingAndSavingsAcctBalance;
	
	public CustomerToDo(double checkingAcctBalance, double savingsAcctBalance) {
		this.checkingAcctBalance = checkingAcctBalance;
		this.savingsAcctBalance = savingsAcctBalance;
	}
	
	public CustomerToDo(double checkingAcctBalance) {
		this.checkingAcctBalance = checkingAcctBalance;
		}
	
	public CustomerToDo(int savingsAcctBalance) {
		this.savingsAcctBalance = savingsAcctBalance;
	}
	
//	public double getCheckingAndSavingsAcctBalance() {
//		return checkingAndSavingsAcctBalance;
//	}
//	public void setCheckingAndSavingsAcctBalance(double checkingAndSavingsAcctBalance) {
//		this.checkingAndSavingsAcctBalance = checkingAndSavingsAcctBalance;
//	}
	public double getCheckingAcctBalance() {
		return checkingAcctBalance;
	}
	public void setCheckingAcctBalance(double checkingAcctBalance) {
		this.checkingAcctBalance = checkingAcctBalance;
	}
	public double getSavingsAcctBalance() {
		return savingsAcctBalance;
	}
	public void setSavingsAcctBalance(double savingsAcctBalance) {
		this.savingsAcctBalance = savingsAcctBalance;
	}

	
}
