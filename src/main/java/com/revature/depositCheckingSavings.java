package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class depositCheckingSavings {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
	public void deposit() {
		CustomerMenu menu = new CustomerMenu();
		Scanner scan = new Scanner(System.in);
		System.out.println("username:");
		String customer = scan.nextLine();
		
		System.out.println("How much money would you like to deposit into your checking acct?: ");
		String deposit = scan.nextLine();
		int depositChecking = Integer.parseInt(deposit);
		
		System.out.println("How much money would you like to deposit into your savings acct?: ");
		String deposit1 = scan.nextLine();
		int depositSavings = Integer.parseInt(deposit1);
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			String sql = "update customer_checkingandsavings set checking_acct = (checking_acct + ?),savings_acct =(savings_acct + ?) where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, depositChecking);
			ps.setInt(2, depositSavings);
			ps.setString(3,customer);
			ps.executeUpdate();
			System.out.println("deposit sucessful!");
			menu.display();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
	}

}
