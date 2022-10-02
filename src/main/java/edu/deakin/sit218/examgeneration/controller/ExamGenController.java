package edu.deakin.sit218.examgeneration.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;;

@Controller
public class ExamGenController {
	@GetMapping("/examgenview")
	public String examgen(@RequestParam("areaOfKnowledge") String areak, Model model) {
		
		String jdbcURL = "jdbc:mysql://localhost/examappschema?" +
                "user=coachdbadmin&password=12345";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			System.out.println("Connection successful!");
			
			//Perform a query
			
			String pQuery="SELECT question FROM exampaper WHERE areaofknowledge = ?";
			PreparedStatement pStatement = conn.prepareStatement(pQuery);
			pStatement.setString(1, areak);
			
			ResultSet result = pStatement.executeQuery();
			int counter=1;
			
			
			
			SecurityContext context = SecurityContextHolder.getContext();
		    System.out.println(context.getAuthentication().getName());
		    
		    
		    Logger logger = Logger.getLogger("MyLog"); 
		    boolean append = true;
		    FileHandler fh;  

		    try {  

		        // This block configure the logger with handler and formatter 
		    	
		        fh = new FileHandler("C:/Users/deols/Desktop/LogFolder/MyLogFile.log",append);  
		        logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);  

		        // the following statement is used to log any messages  
		        logger.info("User "+context.getAuthentication().getName()+" has requested for five questions from "+areak+" (Area of Knowledge)");  

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }	     

		     
		    	    
		    
		    
			while(result.next()) {
				
				String question = result.getString("question");
				model.addAttribute("message"+String.valueOf(counter),question);
				System.out.println(question);
				counter=counter+1;
			}
			
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		
		return "examgenview";
	}
	
	@GetMapping("/examgen")
	public String showHome() {
		return "examgen";
	}
	
	
	
	
}
