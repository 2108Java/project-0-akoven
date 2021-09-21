package com.revature;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerMenu {
	
	
	public void Credentials() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Username: ");
		String UsernameSelect = scan.nextLine();
		System.out.println("Password: ");
		String PasswordSelect = scan.nextLine();


		correctLogIn user = new correctLogIn();
		UsernameCheck[] usernameArray = user.newUsername();
		PasswordCheck[] passwordArray = user.newPassword();

		
		for(int i = 0; i < usernameArray.length; i++) {
			if(usernameArray[i] != null){//customer approval taken care of in ApprovalCheck class
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
			System.out.println("1. Open an account");
			System.out.println("2. View balance");
			System.out.println("3. Make a deposit");
			System.out.println("4. Make a withdrawl");
			System.out.println("5. Delete an account");//this should trigger an employee approval?
			System.out.println("6. Exit application");
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
					OpenNewAccount newAccount = new OpenNewAccount(); 
					break;
				case"2":
					AccountActivity balance = new AccountActivity();
					break;
				case"3":
					AccountActivity deposit = new AccountActivity();
					break;
				case"4":
					AccountActivity withdrawl = new AccountActivity();
					break;
				case"5":
					AccountActivity delete = new AccountActivity();
				case"6":
					System.out.println("Thank you for using my app!");
					running = false;
					break;
				default:
					System.out.println("that is not a valid input!");
		}

	}
  }
}
