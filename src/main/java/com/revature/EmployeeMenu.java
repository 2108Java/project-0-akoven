package com.revature;

import java.util.Scanner;

import org.apache.log4j.Level;

public class EmployeeMenu {
	
	public void Credentials() {

		Scanner scan = new Scanner(System.in);
		System.out.println("First name: ");
		String Firstname = scan.nextLine();
		System.out.println("Last name: ");
		String Lastname = scan.nextLine();
		System.out.println("Password: ");
		String PasswordSelect = scan.nextLine();
		
		correctEmployeeLogIn employee = new correctEmployeeLogIn();
		FirstnameCheck[] firstArray = employee.newFirstname();
		LastnameCheck[] lastArray = employee.newLastname();
		PasswordCheck[] passwordArray = employee.newPassword();
		
//		private void DisplayOfArray(employeeToDo[] array) {
//			for(int i = 0; i<array.length; i++) {
//				if(array[i] != null) {
//					System.out.println(array[i].getCustomer_ID());
//					System.out.println(array[i].getUsername());
//					System.out.println(array[i].getIsApproved());
//					System.out.println("");
//				}
//			}
//		}
		
//		correctEmployeeLogIn user = new correctEmployeeLogIn();
//		FirstnameCheck[] FirstnameArray = user.newFirstname();
//		LastnameCheck[] LastNameArray = user.newLastname();
//		PasswordCheck[] passwordArray = user.newPassword();
	
		for(int i = 0; i < passwordArray.length; i++) {
			if(firstArray[i]!=null) {
				if(Firstname.equals(firstArray[i].getFirstname())) {
					if(Lastname.equals(lastArray[i].getLastname())) {	
						if(PasswordSelect.equals(passwordArray[i].getPassword())) {
						display();
						}else {
							System.out.println("Password is incorrect or the first and last name entered is not in our system. Try again");
							Credentials();
					}
				}
			}
		}	
	}
}
		
		public void OptionsMenu(){
			System.out.println("Hello, here are your tasks: ");
			System.out.println("1. View unapproved accounts");
			System.out.println("2. Approve an account");
			System.out.println("3. See approved accounts");
			System.out.println("4. See all accounts");
			System.out.println("5. Exit application");
	}
	
		public void display() {
			
			Scanner scan = new Scanner(System.in);
			
			boolean running = true;
			while(running) {
				OptionsMenu();
				String input = scan.nextLine();
				
				MainDriver.Bank.setLevel(Level.WARN);
				switch(input) {		
					case"1":
						EmployeeActivities seeUnapproved = new EmployeeActivities();
						seeUnapproved.SeeUnapprovedAccounts();
						MainDriver.Bank.info("Employee is viewing all unapproved accounts");
						break;
					case"2":
						EmployeeActivities approveAcct = new EmployeeActivities();
						approveAcct.approveAccounts();
						MainDriver.Bank.info("Employee is approving an account");
						break;
					case"3":
						EmployeeActivities seeApproved = new EmployeeActivities();
						seeApproved.seeAllApprovedAccounts();
						MainDriver.Bank.info("Employee is viewing all approved accounts");
						break;
					case"4":
						EmployeeActivities ea = new EmployeeActivities();
						ea.SeeAllAccounts();
						MainDriver.Bank.info("Customer is viewing all accounts(approved and unapproved)");
						break;
					case"5":
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
