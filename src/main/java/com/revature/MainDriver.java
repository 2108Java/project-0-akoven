package com.revature;

public class MainDriver {
	public static void main(String[] args) {
//		CustomerToDo test = new CustomerToDo();//object "test" is a new instance of class CustomerToDo
//		String Username = test.CustomerSignUp_username(); //using methods established in CustomerToDo class
//		String Password = test.CustomerSignUp_passcode();
//		System.out.println(Username);
//		System.out.println(Password);//this block of code works
		
//		CustomerMenu menu = new CustomerMenu();
//		System.out.println(menu);//this line just prints the memory location for the object "menu"
//		menu.OptionsMenu();//displays the options menu in CustomerMenu class
//		menu.Credentials();//this line works, changed Credentials to public
		
//		UserMenu.SignIn();//I don't have to instantiate a new instance of UserMenu
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Would you like to open a new account? (y/n)");
//		String response = scan.nextLine();
//		System.out.println(response.equals("y"));
//		CustomerToDo customer = new CustomerToDo();
//		customer.CustomerSignUp_username();
		
//		Scanner scan = new Scanner(System.in); //this block of code shows that Username is being stored in the CustomerToDo class
//		CustomerToDo customer = new CustomerToDo();
//		System.out.println("Enter a Username: ");
//		String Username = scan.nextLine();
//		customer.setUsername(Username);
//		String correctUsername = customer.getUsername();
//		System.out.println("Enter a Password: ");
//		String Password = scan.nextLine();
//		customer.setPassword(Password);
//		String correctPassword = customer.getPassword();
//		System.out.println(customer.getUsername());
//		if(Username.equals(correctUsername)&& Password.equals(correctPassword)) {
//			System.out.println("Success!");
//		}else {
//			System.out.println("no go");
//		}
//	
		
//		

		UserMenu user = new UserMenu();
		user.SignIn();//first thing a user should see, they will select whether they are a customer or an employee
//		
		
//		CustomerMenu test = new CustomerMenu();
//		test.Credentials();
		
//		EmployeeActivities test = new EmployeeActivities();
//		test.SeeAllAccounts();
		
		
//		runningTest = false;
		//after the new customer signs in we need the employee to approve the new account
		//a returning customer should be re-directed to the CustomerMenu


//		}
	}
}

