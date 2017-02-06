package com.onlineproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineproduct.domain.User;
import com.onlineproduct.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getlogin() {
		return "index";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getUserLoginForm(@ModelAttribute("addNewUser") User user) {
		return "addUserForm";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST) 
	public String processUserLoginForm(@ModelAttribute("addNewUser") User user) {
		userRepository.saveOrUpdate(user);
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/welcome",  method = RequestMethod.GET) 
	public String getWelcomePage() {
		return "welcome";
	}
}
