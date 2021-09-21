package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class correctEmployeeLogIn {

	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

	public FirstnameCheck[] newFirstname() {
		FirstnameCheck[] firstArray = new FirstnameCheck[50];
		try(Connection connection = DriverManager.getConnection(url,username,password)) {
			String sql = "Select *from Employee_ID";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				firstArray[i] = new FirstnameCheck(rs.getString("employee_firstname"));
				i++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}return firstArray;
	}
	
	public LastnameCheck[] newLastname() {
		LastnameCheck[] lastArray = new LastnameCheck[50];
		try(Connection connection = DriverManager.getConnection(url,username,password)) {
			String sql = "Select *from Employee_ID";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				lastArray[i] = new LastnameCheck(rs.getString("employee_lastname"));
				i++;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}return lastArray;
		
	}
	
	public PasswordCheck[] newPassword() {
		
		PasswordCheck[] PasswordArray = new PasswordCheck[50];
		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sqlFind = "select *from Employee_ID";
			PreparedStatement ps = conn.prepareStatement(sqlFind);
			ResultSet rs = ps.executeQuery();
			
		int i = 0;
		while(rs.next()) {
			PasswordArray[i] = new PasswordCheck(rs.getString("employee_password"));
			i++;
	}
		}catch(SQLException e) {
			e.printStackTrace();
		}return PasswordArray;
	}
	
}


