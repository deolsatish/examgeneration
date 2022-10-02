package edu.deakin.sit218.examgeneration.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionAnswerController {
	
	@GetMapping("/questionanswerview")
	public String questionanswerview(@RequestParam("areaOfKnowledge") String areaofknowledgef,@RequestParam("lecturername") String lecturernamef,@RequestParam("question") String questionf,@RequestParam("answer") String answerf, Model model) {
		
		
		String jdbcURL = "jdbc:mysql://localhost/examappschema?" +
                "user=coachdbadmin&password=12345";
		try {
			System.out.println("Connecting to Database");
			Connection conn =
		       DriverManager.getConnection(jdbcURL);
			System.out.println("Connection successful!");
			
			//Perform a query
			
			
			Statement statement = conn.createStatement();
			
			String pQuery = "INSERT INTO exampaper (lecturername, question, answer, areaofknowledge) VALUES (?,?,?,?)";
			PreparedStatement pStatement = conn.prepareStatement(pQuery);
			pStatement.setString(1, lecturernamef);
			pStatement.setString(2, questionf);
			pStatement.setString(3, answerf);
			pStatement.setString(4, areaofknowledgef);
			
			pStatement.executeUpdate();
			
			model.addAttribute("message","Update Successful");
			
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
		        logger.info("User "+context.getAuthentication().getName()+" has requested for insertion of question: "+questionf+" , answer: "+answerf+" , area of knwoledge: "+areaofknowledgef+" , lecturername: "+lecturernamef+" into exampaper database");  

		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }	
			
						
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		return "questionanswerview";	
	}
	
	
	@GetMapping("/question-answer")
	public String showHome() {
		return "question-answer";
	}
}
