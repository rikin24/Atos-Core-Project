package com.qa.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDqueries {

	private Connection conn;// has a driver manager class which contains the methods to connect to db
	private Statement stmt;// allows us to prepare the query we want to execute
	private ResultSet rs; // Crucial for when returning multiple rows from a database table

	// open connection in the constructor - initialises everything
	public CRUDqueries() {
		try {
			conn = DriverManager.getConnection(DBconfig.URL, DBconfig.USER, DBconfig.PASS);
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}
	
	public void create(Customer c) {

//		public void create(String model, int mileage, String vehicleType, int doors) {
			// info to collect to pass into the database
//			String model = "xxx";
//			int mileage = 1234;
//			String vehicleType = "Bike";
//			int doors = 2;

			// INSERT INTO vehicle(model, mileage, vehicle_type, doors)
			// VALUES("tbc",30000,"Car",4);
			String createStmt = "INSERT INTO customers(fName, sName, address, postcode) VALUES('" + c.getfName() + "','" + c.getsName()
					+ "','" + c.getAddress() + "','" + c.getPostcode() + "');";
			try {
				stmt.executeUpdate(createStmt);
				System.out.println("Create statement executed");
			} catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}
		}	
	
	// READ - SELECT ..... -> executeQuery
	public void read() {
		String readStmt = "SELECT * FROM customers;";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First name: " + rs.getString("fName"));
				System.out.println("Second name: " + rs.getString("sName"));
				System.out.println("Address: " + rs.getString("address"));
				System.out.println("Postcode: " + rs.getString("postcode"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	// UPDATE - UPDATE ..... -> executeUpdate
	public void update(int id, String updateVal) {
//		UPDATE vehicle SET model = "chevy" WHERE id = 2;
		String updateStmt = "UPDATE customers SET fName = '" + updateVal + "' WHERE id = " + id + ";";
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}

	// DELETE - DELETE ..... -> executeUpdate
	public void delete(int id) {
		String delStmt = "DELETE FROM customers WHERE id=" + id + ";";
		try {
			stmt.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}

	// close the connection
	public void closeConn() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}
	
}
