package com.sakthi.database;

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

public String  submit(Model model,@ModelAttribute("login") Login login) {

	String name=login.getUserName();
	String pass=login.getPassword();

	if(name.equals("") || pass.equals("")) {
		model.addAttribute("msg", "Enter your credentials");
		return "home";
	}
	else {
		MyService ms= new MyService();
		ms.validate(model,name,pass);	
		return "Disp";
	}

   }

}

