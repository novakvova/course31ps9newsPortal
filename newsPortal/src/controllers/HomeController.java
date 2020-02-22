package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import services.AuthService;

@Controller
public class HomeController {
	
	 @Autowired
	 private AuthService authService;            // This will auto-inject the authentication service into the controller.
	 
	@RequestMapping("/home")
	public String index() {
		
		this.authService.Test();
				
		return "home";
	}

}
