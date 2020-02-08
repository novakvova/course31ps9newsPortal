package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.LoginDTO;

@Controller
public class AccountController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		System.out.println("------Get login-----");
		LoginDTO login = new LoginDTO();
		login.setEmail("smonder@gmail.com");
		
		model.addAttribute("user", login);
		return "account/login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user")LoginDTO user, 
      BindingResult result, ModelMap model) {
		String email=user.getEmail();
		System.out.println("-----post login-------"+email);
		//String password=user.getPassword();
		if(email.equals("admin@gmail.com"))
			return "account/user-profile";
		else
			return "account/login";
    }
}