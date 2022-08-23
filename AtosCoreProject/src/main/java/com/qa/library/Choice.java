package com.qa.library;

import java.util.Scanner;

public class Choice {

	private static Scanner sc = new Scanner(System.in);
	Customer cm = new Customer();

	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}

	public void options() {
		// create an instance of the CRUD queries class to open the connection
		CRUDqueries q = new CRUDqueries();

		// Ask for user input on the CRUD choice in the getInput method and store the
		// result in the crud variable
		String crud = getInput();

		// try-finally block so the finally block can close the connection
		try {
			// do-while loop to start the loop and present the options to interact with the
			// database
			do {
				// switch case to match which CRUD operation to perform
				switch (crud.toLowerCase()) {
				case "create":
					System.out.println("Enter first name: ");
					String fName = sc.nextLine();
					cm.setfName(fName);
					
					System.out.println("Enter second name: ");
					String sName = sc.nextLine();
					cm.setsName(sName);
					
					System.out.println("Enter address: ");
					String address = sc.nextLine();
					cm.setAddress(address);
					
					System.out.println("Enter postcode: ");
					String postcode = sc.nextLine();
					cm.setPostcode(postcode);
					
					q.create(cm);
					break;
				case "read":
					q.read();
					break;
				case "update":
					System.out.println("Enter id of record to update: ");
					int uid = sc.nextInt();
					sc.nextLine();//capture enter key
					System.out.println("Enter the new first name: ");
					String nFN = sc.nextLine();
					q.update(uid, nFN);					
					break;
				case "delete":
					System.out.println("Enter id of customer to delete: ");
					int id = sc.nextInt();
					sc.nextLine();//capture enter key
					q.delete(id);
					break;
				default:
					System.out.println("Invalid CRUD choice");
				}
				// check if user wants to continue or break out of the loop
				System.out.println("Would you like to continue? (y/n)");
				String quit = sc.nextLine();
				if (quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if (quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}

			} while (!crud.equals("quit"));
			System.out.println("Goodbye!");
		} finally {
			q.closeConn();
		}
	}
	
}
