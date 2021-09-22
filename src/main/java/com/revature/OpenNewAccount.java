package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OpenNewAccount {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

	public void newAccount(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Thank you for choosing Bank A! Would you like to open a 1)checking account, 2)savings account, or 3)both?: ");	
		String selection = scan.nextLine();
		
		boolean running = true;
		
		while(running) {
			
			switch(selection) {
				case"1":
					CheckingAcct();
					break;
				case"2":
					SavingsAcct();
					break;
				case"3":
					CheckingAndSavingsAcct();
					break;
		}
	}
	

}
	public void CheckingAcct() {
		
//		CheckingTotal[] checkingAcctArray = new CheckingTotal[50];
		
		CustomerMenu menu = new CustomerMenu();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String customer = scanner.nextLine();
		
		System.out.println("How much would you like to deposit intially(0 dollars is an option)?:");
		String value = scanner.nextLine();
		int money = Integer.parseInt(value);
		
		if (money < 0) {
			System.out.println("Positive values only!");
		}else {
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "insert into customer_checking(customer_username,checking_acct) values (?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, customer);
				ps.setInt(2, money);
				ps.execute();
				System.out.println("Your checking account has been created.");
				menu.display();
			
				
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	}
	
	public void SavingsAcct() {
		
		CustomerMenu menu = new CustomerMenu();
		
//		SavingsTotal[] savingAcctArray = new SavingsTotal[50];
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String customer = scanner.nextLine();
		
		System.out.println("How much would you like to deposit intially (0 dollars is an option)?:");
		String value = scanner.nextLine();
		int money = Integer.parseInt(value);
		if (money < 0) {
			System.out.println("Positive values only!");
			newAccount();
		
		}else {
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "insert into customer_savings(customer_username,savings_acct)values(?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, customer);
				ps.setInt(2, money);
				ps.execute();
				System.out.println("Your savings account has been created" );
				menu.display();
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 	
		
	}
	
	public void CheckingAndSavingsAcct() {
		
//		Checking_Savings[] CheckingAndSavingsAcctArray = new SavingsTotal[50];
		
		CustomerMenu menu = new CustomerMenu();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String customer = scanner.nextLine();
		System.out.println("How much would you like to deposit intially into your checking account(0 dollars is an option)?:");
		String value = scanner.nextLine();
		int moneyChecking = Integer.parseInt(value);
		
		System.out.println("How much would you like to deposit intially into your checking account(0 dollars is an option)?:");
		String value1 = scanner.nextLine();
		int moneySavings = Integer.parseInt(value1);
		if (moneyChecking < 0 || moneySavings < 0) {
			System.out.println("Positive values only!");
		}else {
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "insert into customer_checkingandsavings(customer_username,checking_acct,savings_acct) values (?,?,?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, customer);
				ps.setInt(2, moneyChecking);
				ps.setInt(3,moneySavings);
				ps.execute();
				System.out.println("Your joint checking/savings account has been created");
				menu.display();
			
			}catch(SQLException e) {
				e.printStackTrace();
		}
	}
//		System.out.println("How much would you like to deposit intially into your savings account(0 dollars is an option)?:");
//		String value1 = scanner.nextLine();
//		int money1 = Integer.parseInt(value1);
//		if (money1 < 0) {
//			System.out.println("Positive values only!");
//			newAccount();
//		}else {
//			try(Connection connection1 = DriverManager.getConnection(url,username,password)){
//				String sqlFind = "insert into customer_savings(customer_username,savings_acct) values (?,?)";
//				PreparedStatement psFind = connection1.prepareStatement(sqlFind);
//				psFind.setString(1, customer);
//				psFind.setInt(2, money1);
//				psFind.execute();
//			
//				System.out.println("Your joint checking-savings account has been created" );
//				menu.display();
//			
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
}