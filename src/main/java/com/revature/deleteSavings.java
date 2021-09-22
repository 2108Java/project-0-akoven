package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteSavings {
		
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
	public void delete() {
			
			CustomerMenu menu = new CustomerMenu();
			Scanner scan = new Scanner(System.in);
			System.out.println("username:");
			String customer = scan.nextLine();
			
		try(Connection connection = DriverManager.getConnection(url,username,password)){
				String sql = "delete from customer_savings where customer_username = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1,customer);
				ps.execute();
				System.out.println("Account successfully deleted");
				menu.display();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
	

