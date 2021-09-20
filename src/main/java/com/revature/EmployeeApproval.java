package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class EmployeeApproval{
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

	
	public employeeToDo[] SeeAllAccounts(){
		
		employeeToDo[] seeAllCustomers = new employeeToDo[50];
						
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			String sql = "select *from  Customer_ID";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
				
			int i = 0;
			while (rs.next()) {
				seeAllCustomers[i] = new employeeToDo(rs.getString("customer_username"),rs.getBoolean("isApproved"));
				System.out.println(seeAllCustomers[i]);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}return seeAllCustomers;
	}
	
		public employeeToDo[] SeeUnapprovedAccounts() {
			employeeToDo[] seeAllUnapproved = new employeeToDo[50];
			
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "select *from  Customer_ID where isApproved = false";
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				int i = 0;
				while (rs.next()) {
					seeAllUnapproved[i] = new employeeToDo(rs.getString("customer_username"),rs.getBoolean("isApproved"));
		}
			}catch(SQLException e) {
				e.printStackTrace();
		}return seeAllUnapproved;
	}
		
		public boolean ApproveAccounts() {
			boolean success = false;
			
			Scanner scan = new Scanner(System.in);
			System.out.println("which user would you like to approve(type userID)?: ");
			String user = scan.nextLine();
			int UserID = Integer.parseInt(user);
			
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				
				String sql = "select *from Customer_ID where customer_id = ? set isApproved = true";
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setInt(1, UserID);
				ps.execute();
				success = true;
				if(success) {
					System.out.println("This customer's account has been approved!");
				}else {
					System.out.println("This account is not approved");
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}return success;
}
		public employeeToDo[] seeAllApprovedAccounts() {
			employeeToDo[] seeAllApproved = new employeeToDo[50];
			
			try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "select *from  Customer_ID where isApproved = true";
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				int i = 0;
				while (rs.next()) {
					seeAllApproved[i] = new employeeToDo(rs.getString("customer_username"),rs.getBoolean("isApproved"));
		}
			}catch(SQLException e) {
				e.printStackTrace();
		}return seeAllApproved;
	}
		}

			

