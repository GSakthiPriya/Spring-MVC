package com.sakthi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.ui.Model;

public class MyService {

public void validate(Model model,String name, String pass) {


	try {
		Class.forName("com.mysql.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stmt=con.createStatement();
	
		ResultSet rs=stmt.executeQuery("select * from login");

		while(rs.next())

			if(name.equals(rs.getString(1)) && pass.equals(rs.getString(2)) ) {
			model.addAttribute("msg", name);	 
   			}
	
		}
	catch(Exception e) {
		System.out.println(e);

	  }

 }

}

