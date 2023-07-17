package com.abess.prj.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.abess.prj.Entity.user;

import com.abess.prj.Service.userService;

import jakarta.servlet.http.HttpSession;

@Controller

public class userController {
	@Autowired
	private final userService user_Service ;
	
	
	public userController(userService user_Service) {
		super();
		this.user_Service = user_Service;
	}
	@GetMapping({"/register","/"})
	
    
	public String getRegisterPage(Model model ) {
		model.addAttribute("registerRequest", new user());
		
		return"register_page";
	}

	@GetMapping("/login")
	
	public String getLoginPage(Model model ,HttpSession session) {
		session.setAttribute("connected", "no");
		model.addAttribute("registerRequest", new user());
		return"login_page";
	}

	
	@PostMapping("/register")

	public String Register(@ModelAttribute user user1 ) {
		user registerUser = user_Service.registerUser(user1.getlogin(), user1.getPassword()) ;
		
		return registerUser ==null ? "register" : "redirect:/login";
	}
	@PostMapping("/login")

	public String login(@ModelAttribute user user1 ,HttpSession session ) {
		user authentificated = user_Service.authentificate(user1.getlogin(), user1.getPassword());
      
		//return authentificated ==null ? "redirect:/login" : session.setAttribute("id", user1.getId()), "redirect:/students";
        if (authentificated !=null) {
        	session.setAttribute("connected", "yes");
        	return "redirect:/students";
        }
        return "redirect:/login" ;
	}
}
