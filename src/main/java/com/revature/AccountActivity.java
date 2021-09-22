package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountActivity {
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "@kljeo88";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

//option 2
	public void seeBalances() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("For which account would you like to see your current balance?: ");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println("3. Checking/Savings");
		
		
		boolean running = true;
		while(running) {
			String selection = scan.nextLine();
		
			switch(selection) {
				case"1":
					seeChecking();
					break;
				case"2":
					seeSavings();
					break;
				case"3":
					seeCheckingAndSavings();
					break;
			}
	}

}

	private CustomerToDo[] seeChecking() {
		
		CustomerMenu menu = new CustomerMenu();
		
		Scanner scan = new Scanner(System.in);
		CustomerToDo[] seeAllChecking = new CustomerToDo[50];
		System.out.println("username:");
		String customer = scan.nextLine();
		try(Connection connection = DriverManager.getConnection(url,username,password)) {
			String sql = "select *from customer_checking where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, customer);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				seeAllChecking[i] = new CustomerToDo(rs.getInt("checking_acct"));
				System.out.println(seeAllChecking[i].getCheckingAcctBalance());
				menu.display();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}return seeAllChecking;
		
	}
	
	private CustomerToDo[] seeSavings() {
		
		CustomerMenu menu = new CustomerMenu();
		
		Scanner scan = new Scanner(System.in);
		CustomerToDo[] seeAllSavings = new CustomerToDo[50];
		System.out.println("username:");
		String customer = scan.nextLine();
		try(Connection connection = DriverManager.getConnection(url,username,password)) {
			String sql = "select *from customer_savings where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, customer);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				seeAllSavings[i] = new CustomerToDo(rs.getInt("savings_acct"));
				System.out.println(seeAllSavings[i].getSavingsAcctBalance());
				menu.display();
			}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}return seeAllSavings;
	}
	
	private void seeCheckingAndSavings() {
		
		CustomerMenu menu = new CustomerMenu();
		
		Scanner scan = new Scanner(System.in);
		CustomerToDo[] seeAllChecking = new CustomerToDo[50];
		CustomerToDo[] seeAllSavings = new CustomerToDo[50];
		System.out.println("username:");
		String customer = scan.nextLine();
		try(Connection connection = DriverManager.getConnection(url,username,password)) {
			String sql = "select *from customer_checkingandsavings where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, customer);
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				seeAllChecking[i] = new CustomerToDo(rs.getInt("checking_acct"),rs.getInt("savings_acct"));
				seeAllSavings[i] = new CustomerToDo(rs.getInt("checking_acct"), rs.getInt("savings_acct"));
				System.out.println(seeAllChecking[i].getCheckingAcctBalance());
				System.out.println(seeAllSavings[i].getSavingsAcctBalance());
				menu.display();			
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			}
			
//		CustomerToDo[] seeAllSavings = new CustomerToDo[50];
//		try(Connection connection1 = DriverManager.getConnection(url,username,password)) {
//			String sqlFind = "select *from customer_savings where customer_username = ?";
//			PreparedStatement psFind = connection1.prepareStatement(sqlFind);
//			psFind.setString(1, customer);
//			ResultSet rs1 = psFind.executeQuery();
//			
//			int i = 0;
//			while(rs1.next()) {
//				seeAllSavings[i] = new CustomerToDo(rs1.getInt("savings_acct"));
//				System.out.println(seeAllSavings[i].getSavingsAcctBalance());
//				menu.display();
//			}	
//	}catch(SQLException e) {
//		e.printStackTrace();
//	}
//				
}
	//option 5
	public void makeTransfer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What kind of transfer would you like to make?: ");
		System.out.println("1. Checking to Savings");
		System.out.println("2. Savings to Checking");
		String input = scan.nextLine();
		
		boolean running = true;
		while(running) {
			switch(input) {
				case"1":
					csTransfer();
					break;
				case"2":
					scTransfer();
					break;
			}
		}
	}

	private CustomerToDo[] csTransfer() {
		
		CustomerToDo[] csTransferArray = new CustomerToDo[50];
		Scanner scan = new Scanner(System.in);
		CustomerMenu menu = new CustomerMenu();
		
		System.out.println("username:");
		String customer = scan.nextLine();
		System.out.println("How much money do you want to transfer out of your checking account?: ");
		String money = scan.nextLine();
		int moneyTransfer = Integer.parseInt(money);
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			String sql = "update customer_checkingandsavings set checking_acct = (checking_acct - ?),savings_acct = (savings_acct + ?) where customer_username = ?";
//			String sqlFind = "update customer_savings set savings_acct = (savings_acct + ?) where customer = ?";
	
			PreparedStatement ps = connection.prepareStatement(sql);
			
			
			ps.setInt(1, moneyTransfer);
			ps.setInt(2, moneyTransfer);
			ps.setString(3, customer);
			int rs = ps.executeUpdate();
			System.out.println("Transfer successful!");
			menu.display();
			
		}catch(SQLException e) {
			e.printStackTrace();
				}return csTransferArray;
	}

	private void scTransfer() {
//		CustomerToDo[] scTransferArray = new CustomerToDo[50];
		Scanner scan = new Scanner(System.in);
		CustomerMenu menu = new CustomerMenu();
		
		System.out.println("username:");
		String customer = scan.nextLine();
		System.out.println("How much money do you want to transfer out of your savings account?: ");
		String money = scan.nextLine();
		int moneyTransfer = Integer.parseInt(money);
		
		try(Connection connection = DriverManager.getConnection(url,username,password)){
			String sql = "update customer_checkingandsavings set savings_acct = (savings_acct - ?),checking_acct = (checking_acct + ?) where customer_username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, moneyTransfer);
			ps.setInt(2, moneyTransfer);
			ps.setString(3, customer);
			ps.executeUpdate();
	
			System.out.println("Transfer successful!");
			menu.display();
					
				}catch(SQLException e) {
					e.printStackTrace();
			}
		}
	
	//option 6
		public void deleteAccount() {
			
			Scanner scan = new Scanner(System.in);
			CustomerMenu menu = new CustomerMenu();
			
			System.out.println("Are you sure you want to delete your account(y/n)? ");
			String decision = scan.nextLine();
			
			if(decision.equals("y")) {
	
				System.out.println("which account would you like to delete?");
				System.out.println("1.checking");
				System.out.println("2.savings");
				System.out.println("3.checking/savings");
				String selection = scan.nextLine();
			
				boolean running = true;
				while(running) {
					switch(selection) {
						case"1":
							deleteChecking dc = new deleteChecking();
							dc.delete();
							break;
						case"2":
							deleteSavings ds = new deleteSavings();
							ds.delete();
							break;
						case"3":
							deleteCheckingSavings dcs = new deleteCheckingSavings();
							dcs.delete();
					}
			}
			
			}
			if(decision.equals("n")){
				menu.display();
			}
		}
	}



