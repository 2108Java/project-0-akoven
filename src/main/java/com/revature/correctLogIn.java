package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class correctLogIn {	
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
//	       <return type>         <method>	
	public UsernameCheck[] newUsername(){

		UsernameCheck[] UsernameArray = new UsernameCheck[50];
 		try(Connection conn = DriverManager.getConnection(url,username,password)){
				String sqlFind = "select *from Customer_ID";
				PreparedStatement ps = conn.prepareStatement(sqlFind);
				ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
					UsernameArray[i] = new UsernameCheck(rs.getString("customer_username"));
//					System.out.println(UsernameArray[i].getUsername());
					i++;
			}
	}catch(SQLException e){
			e.printStackTrace();
			
	}	return UsernameArray;	
		}
	public PasswordCheck[] newPassword() {
		
		PasswordCheck[] PasswordArray = new PasswordCheck[50];
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sqlFind = "select *from Customer_ID";
			PreparedStatement ps = conn.prepareStatement(sqlFind);
			ResultSet rs = ps.executeQuery();
			
		int i = 0;
		while(rs.next()) {
			PasswordArray[i] = new PasswordCheck(rs.getString("customer_passcode"));
			i++;
	}
		}catch(SQLException e) {
			e.printStackTrace();
		}return PasswordArray;
	}
	
}
//	
//	public void checkPassword() {
//			
//		try(Connection conn = DriverManager.getConnection(url,username,password)){//retrieving customer_password to assign to String correctPassword
//			String sqlPassword = "select *from Customer_ID where customer_passcode = ?";
//			PreparedStatement ps2 = conn.prepareStatement(sqlPassword);
//				
//			CustomerToDo ctd1 = new CustomerToDo();
//			String currentPassword = ctd1.getPassword();
//			ps2.setString(1,currentPassword);
//			ResultSet rs = ps2.executeQuery();
//				
//			while(rs.next()) {
//				rs.getString("customer_passcode");
//				if(rs.getString("customer_passcode").equals(currentPassword)) {
//						String correctPassword = currentPassword;
//						
//				}else {
//					System.out.println("user's account has not been approved or doesn't exist");
//					}
//				}
//			
//				
//			}catch(SQLException e) {
//				e.printStackTrace();
//				
//			}
		

		