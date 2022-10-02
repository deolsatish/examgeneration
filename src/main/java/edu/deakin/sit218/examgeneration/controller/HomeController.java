package edu.deakin.sit218.examgeneration.controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
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
	        logger.info("User "+context.getAuthentication().getName()+" has logged in.");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }	    
	    
	    
		return "home";
	}
}
