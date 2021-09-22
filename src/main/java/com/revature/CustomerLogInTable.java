package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class CustomerLogInTable{
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";


	public void logIn(){
		
		Scanner scan = new Scanner(System.in);
		CustomerLogIn customer = new CustomerLogIn();
		System.out.println("Enter a Username: ");
		String customerUsername = scan.nextLine();
		customer.setUsername(customerUsername);	
		
		System.out.println("Enter a password: ");
		String customerPassword = scan.nextLine();
		customer.setPassword(customerPassword);	
			
		try(Connection connection = DriverManager.getConnection(url,username,password)){//saving username and password in sql table
			String sql = "insert into Customer_ID values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, customer.getUsername());//usernames and passwords are being set in the table
			ps.setString(2, customer.getPassword());
			ps.setBoolean(3, false);
			ps.execute();
			System.out.println("Thank you for choosing Bank A! You will receive an account approval notification via email from one of our associates in a few days.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
//		ApprovalChecker ac = new ApprovalChecker;
	
//	 	boolean success = false;
//	 		while(!success){
//				if(EmployeeActivities()){
//					continue;
//					}else{
//						System.out.println("this account has not been approved");
//						success = true;
//							break;
//						
//							}
//	 		}
	 	}

}
	

//			@SuppressWarnings("unused")
//			String correctUsername = rs.getString("customer_username");
//			String correctPassword = rs.getString("customer_password");
			
	

		
		//boolean success = false;
		//if(employeeApproval){
			//CustomerMenu approved = new CustomerMenu();//instantiation of new CustomerMenu object
			//approved.Credentials();
			//success = true;
			//return success
	
























