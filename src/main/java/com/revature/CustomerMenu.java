package com.revature;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {
	
//	private String dbLocation = "localhost";
//	private String username = "postgres";
//	private String password = "@kljeo88";
//	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
//	
//	public boolean approvalCheckForDisplay() {
//		boolean status = false;
//		try(Connection connection = DriverManager.getConnection(url,username,password)){
//			String sql = "select *from  Customer_ID where isApproved = true";
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//		
//			if(UsernameSelect.equals(rs.getString("customer_username"))) {
//				status = true;
//				}
//			}catch(SQLException e) {
//		e.printStackTrace();
//	}return status;
//	approvalCheckForDisplay checkpoint = new approvalCheckForDisplay();
//	if(checkpoint) {
//		display();
//	}
//	}
	
	

	public void Credentials() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Username: ");
		String UsernameSelect = scan.nextLine();
		System.out.println("Password: ");
		String PasswordSelect = scan.nextLine();
		String usernameSelect = UsernameSelect;
		String passwordSelect = PasswordSelect;
		

		correctLogIn user = new correctLogIn();
		UsernameCheck[] usernameArray = user.newUsername();
		PasswordCheck[] passwordArray = user.newPassword();
//		ApprovalCheck[] ApprovalArray = user.newApproval();
		
		for(int i = 0; i < usernameArray.length; i++) {
			if(usernameArray[i] != null){//need to make sure account is approved as well. for some reason boolean values show up as null(none of the accounts have been approved)
				if(UsernameSelect.equals(usernameArray[i].getUsername())) {
					if(PasswordSelect.equals(passwordArray[i].getPassword())) {
						display();
					}else {
						System.out.println("Username or password is incorrect. Try again");
						Credentials();
					}
					}
				}
		}
		}
	
		

		
		public void OptionsMenu(){
			System.out.println("Welcome to Bank A, how can we help you?:");
			System.out.println("1. View balance");
			System.out.println("2. Make a deposit");
			System.out.println("3. Make a withdrawl");
			System.out.println("4. Delete an account");//this should trigger an employee approval?
			System.out.println("5. Exit application");
	}
		
	
//		private void DisplayOfArray(ToDoItem[] customerBalance) {
//			for(int i = 0; i<array.length; i++) {
//				if(array[i] != null) {
//					System.out.println(array[i].CheckingAcctBalance);
//					System.out.println(array[i].SavingsAcctBalance);
//					System.out.println("");
//				}
//			}
			
	public void display() {
	
		Scanner scan = new Scanner(System.in);
	
		boolean running = true;
		while(running) {
			OptionsMenu();
			String input = scan.nextLine();
			
			switch(input) {		
				case"1":
					
					break;
				case"2":
					break;
				case"3":
					break;
				case"4":
					break;
				case"5":
					System.out.println("Thank you for using my app!");
					running = false;
					break;
				default:
					System.out.println("that is not a valid input!");
		}

	}
  }
}
