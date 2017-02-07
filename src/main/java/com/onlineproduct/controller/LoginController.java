package com.onlineproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineproduct.domain.User;
import com.onlineproduct.repository.UserRepository;
import com.onlineproduct.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String getUserRegistration(@ModelAttribute("addNewUser") User user) {
		return "userRegistration";
	}
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST) 
	public String processUserLoginForm(@ModelAttribute("addNewUser") User user) {
		userService.saveOrUpdate(user);
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/welcome",  method = RequestMethod.GET) 
	public String getWelcomePage() {
		return "homepage";
	}
}
