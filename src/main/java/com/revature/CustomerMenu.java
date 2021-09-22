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
			System.out.println("1. Open a checking, savings or checking/savings account");
			System.out.println("2. View balance");
			System.out.println("3. Make a deposit");
			System.out.println("4. Make a withdrawl");
			System.out.println("5. Make a transfer(available for customers with joint checking/savings accounts only!)");
			System.out.println("6. Delete an account");
			System.out.println("7. Exit application");
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
				case"1"://works	
					OpenNewAccount newAccount = new OpenNewAccount(); 
					newAccount.newAccount();
					break;
				case"2"://works
					AccountActivity balance = new AccountActivity();
					balance.seeBalances();
					break;
				case"3":
					AccountActivity deposit = new AccountActivity();
					break;
				case"4":
					AccountActivity withdrawl = new AccountActivity();
					break;
				case"5"://works, but can't put fail safe in for negative values
					AccountActivity transfer = new AccountActivity();
					transfer.makeTransfer();
					break;
				case"6"://works
					AccountActivity delete = new AccountActivity();
					delete.deleteAccount();
					break;
				case"7"://works
					System.out.println("Thank you for using my app!");
					running = false;
					break;
				default:
					System.out.println("that is not a valid input!");
			
		}

	}
  }
}
