package com.revature;

import java.util.Scanner;

public class EmployeeMenu {
	
	public void Credentials() {

		Scanner scan = new Scanner(System.in);
		System.out.println("First name: ");
		String Firstname = scan.nextLine();
		System.out.println("Last name: ");
		String Lastname = scan.nextLine();
		System.out.println("Password: ");
		String PasswordSelect = scan.nextLine();
		
		
		correctLogIn user = new correctLogIn();
		FirstnameCheck[] usernameArray = user.newUsername();
		LastnameCheck[] 
		PasswordCheck[] passwordArray = user.newPassword();
	
		for(int i = 0; i < usernameArray.length; i++) {
			if(Firstname[i].getFirstname() && Lastname[i].getLastname() != null) {
				continue;
				}else {
					System.out.println("That first or last name is not in the system.");
				}
					if(PasswordSelect.equals(passwordArray[i].getPassword())) {
						display();
					}else {
						System.out.println("Password is incorrect. Try again");
						Credentials();
					}
				}
			}

		
		public void OptionsMenu(){
			System.out.println("Hello, here are your tasks: ");
			System.out.println("1. View unapproved accounts");
			System.out.println("2. Approve an account");
			System.out.println("3. See approved accounts");
			System.out.println("4. See all accounts");//this should trigger an employee approval?
			System.out.println("5. Exit application");
	}
	
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
						EmployeeApproval approveAcct = new EmployeeApproval();
						approveAcct.ApproveAccounts();
						break;
					case"3":
						break;
					case"4":
						EmployeeApproval ea = new EmployeeApproval();
						ea.SeeAllAccounts();
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
