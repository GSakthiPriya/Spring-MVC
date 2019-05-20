package com.sakthi.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sakthi.database.Login;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("msg","please provide login details");
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
		
	public String submit(Model model,@ModelAttribute("login") Login login) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from login");

			while(rs.next())
			
				if(login.getUserName().equals(rs.getString(1)) && login.getPassword().equals(rs.getString(2)) ) {
					model.addAttribute("msg", login.getUserName());
				}
			
			return "home";
		}
		catch(Exception e) {
			System.out.println(e);
			return "home";
		}
		
	}
	
}

