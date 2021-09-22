package com.revature;

import java.util.Scanner;

import org.apache.log4j.Level;

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
			
			MainDriver.Bank.setLevel(Level.WARN);
			switch(input) {	
				case"1"://works	
					OpenNewAccount newAccount = new OpenNewAccount(); 
					newAccount.newAccount();
					MainDriver.Bank.info("Customer is opening a new account");
					break;
				case"2"://works
					AccountActivity balance = new AccountActivity();
					balance.seeBalances();
					MainDriver.Bank.info("Customer is viewing account balance");
					break;
				case"3"://works
					AccountActivity deposit = new AccountActivity();
					deposit.makeDeposit();
					MainDriver.Bank.info("Customer is making a deposit");
					break;
				case"4"://works
					AccountActivity withdrawl = new AccountActivity();
					withdrawl.makeWithdrawl();
					MainDriver.Bank.info("Customer is making a withdrawl");
					break;
				case"5"://works, but can't put fail safe in for negative values
					AccountActivity transfer = new AccountActivity();
					transfer.makeTransfer();
					MainDriver.Bank.info("Customer is transferring funds");
					break;
				case"6"://works
					AccountActivity delete = new AccountActivity();
					delete.deleteAccount();
					MainDriver.Bank.info("Customer is deleting an account");
					break;
				case"7"://works
					System.out.println("Thank you for using my app!");
					running = false;
					break;
				default:
					System.out.println("that is not a valid input!");
					MainDriver.Bank.warn("User did not select a valid input");
			
		}

	}
  }
}
