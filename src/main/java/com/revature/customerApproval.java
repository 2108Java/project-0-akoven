package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class customerApproval {
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
//	private boolean isApproved;

	public ApprovalCheck[] approvalChecker() {
	
		ApprovalCheck[] approvalArray = new ApprovalCheck[50];
	
		Scanner scan = new Scanner(System.in);
//		boolean success = false;
		
	
		
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			System.out.println("Check your account status here!");
			System.out.println("Type your username: ");
			String customer = scan.nextLine();
			
			String sqlFind = "select *from Customer_ID where customer_username = ?";
			PreparedStatement psFind = conn.prepareStatement(sqlFind);
			psFind.setString(1,customer);
			ResultSet rs = psFind.executeQuery();
			
			
			int i = 0;
			while (rs.next()) {
				approvalArray[i] = new ApprovalCheck(rs.getBoolean("isApproved"));
//				System.out.println(approvalArray[i].getIsApproved());
//				System.out.println(" ");
				if(approvalArray[i].getIsApproved() == true) {
					System.out.println("Your account has been approved!");	
					CustomerMenu returningCustomer = new CustomerMenu();
					returningCustomer.Credentials();
					}else {
					System.out.println("Your account still needs to be approved");
			}
			
			
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}return approvalArray;
}
}
