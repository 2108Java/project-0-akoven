package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class withdrawCheckingSavings {

	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
		
		public void withdraw() {
			CustomerMenu menu = new CustomerMenu();
			Scanner scan = new Scanner(System.in);
			System.out.println("username:");
			String customer = scan.nextLine();
			
			System.out.println("How much money would you like to withdraw your checking acct?: ");
			String withdrawl = scan.nextLine();
			int withdrawlChecking = Integer.parseInt(withdrawl);
			
			System.out.println("How much money would you like to withdraw your savings acct?: ");
			String withdrawl1 = scan.nextLine();
			int withdrawlSavings = Integer.parseInt(withdrawl1);
			
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "update customer_checkingandsavings set checking_acct = (checking_acct - ?),savings_acct =(savings_acct - ?) where customer_username = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, withdrawlChecking);
				ps.setInt(2, withdrawlSavings);
				ps.setString(3,customer);
				System.out.println("Withdrawl successful!");
				menu.display();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
			
		}

	}
