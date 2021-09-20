package com.revature;

import java.util.Scanner;

public class UserMenu {
		
	public void SignIn() {
		System.out.println("Are you a customer or employee?");
		System.out.println("1) for customer, 2) for employee");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
	
		switch(input) {
			
			case"1":
				System.out.println("Would you like to open a new account? (y/n)");
				String response = scan.nextLine();
				
				if(response.equals("y")) {//why is this not working?program stops after asking if customer would like to open an account(used isEqual method)
					CustomerLogInTable newCustomer = new CustomerLogInTable();
					newCustomer.logIn();
//					CustomerToDo customer = new CustomerToDo();
//					System.out.println("Enter a Username: ");
//					String Username = scan.nextLine();
//					customer.setUsername(Username);
//					
//					System.out.println("Enter a password: ");
//					String password = scan.nextLine();
					//customer.setPassword(password);
//					customer.CustomerSignUp_username();//this piece of code worked before this method was commented out in CustomerToDo
//					customer.CustomerSignUp_passcode();
					
				}
				EmployeeApproval ea = new EmployeeApproval();
				if(response.equals("n") && ea.ApproveAccounts()) {//employeeApproval is going to be a boolean function
					
					CustomerMenu returningCustomer = new CustomerMenu();
					returningCustomer.Credentials();		
				}else{
					System.out.println("Your account needs to be approved");
				break;}
				
			case"2":
				//create an employee class and method
				break;
			
			default: 
				System.out.println("Choose a valid input");
				break;
		}
	
		
	}
}
	
