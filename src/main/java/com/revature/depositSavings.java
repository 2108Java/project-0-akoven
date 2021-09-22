package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class depositSavings {

	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
	public void deposit() {
		CustomerMenu menu = new CustomerMenu();
		Scanner scan = new Scanner(System.in);
		System.out.println("username:");
		String customer = scan.nextLine();
		
		System.out.println("How much money would you like to deposit into your savings acct?: ");
		String deposit = scan.nextLine();
		int depositSavings = Integer.parseInt(deposit);
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			String sql = "update customer_savings set savings_acct =(savings_acct + ?) where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, depositSavings);
			ps.setString(2,customer);
			ps.executeUpdate();
			System.out.println("Deposit successful!");
			menu.display();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}
