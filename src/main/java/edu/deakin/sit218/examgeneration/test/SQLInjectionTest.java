package edu.deakin.sit218.examgeneration.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionTest {
	
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Please enter your area of knowledge: ");
		String areaofknowledge = scanner.nextLine();
		scanner.close();
		String jdbcURL = "jdbc:mysql://localhost/examappschema?" +
                "user=coachdbadmin&password=12345";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			System.out.println("Connection successful!");
			
			//Perform a query
			
			
			Statement statement = conn.createStatement();
			String query = "SELECT question FROM exampaper WHERE areaofknowledge = '"+areaofknowledge+"'";
			System.out.println(query);
			ResultSet result = statement.executeQuery(query);
			while(result.next()) {
				String question = result.getString("question");
				System.out.println(question);
			}
			
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

}