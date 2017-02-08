package com.onlineproduct.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineproduct.domain.User;

import com.onlineproduct.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("user") User user) {
		return "index";
	}
	
	/**
	 * login authentication for normal user and admin user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
		public String loginProcessForm(@ModelAttribute("user") User user,
				boolean remember, @CookieValue(value = "username", defaultValue = "")
				String username, Model model, HttpSession session, HttpServletResponse response) {
		
		
		 boolean isValid = userService.authenticateUser(user);
		 boolean isAdmin = userService.isAdmin(user);
		 
		 if (isValid) {
			 User userInfo = userService.findLoggedInUserInfo(user.getUsername(), user.getPassword());
			 
			 if (remember && username.isEmpty()) {
				 Cookie cookie = new Cookie("username", user.getUsername());
				 cookie.setMaxAge(60);
				 response.addCookie(cookie);
			 
			 } else if (!remember) {
				 Cookie cookie = new Cookie("username", null);
				 cookie.setMaxAge(0);
				 response.addCookie(cookie);
			 }
			 session.setAttribute("userInfo", userInfo);
			 
			 if (isAdmin) {
				 return "redirect:/adminWelcome";
			 
			 } else {
				 return "redirect:/welcome";
			 }
			 
		 
		 }
		 else {
			 return "index";
		 }
		}

	
	/**
	 * User Registration get method which display registration form.
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String getUserRegistration(@ModelAttribute("user") User user) {
		return "userRegistration";
	}

	/**
	 * User Registration Post Method
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String processUserLoginForm(@ModelAttribute("user") User user) {
		userService.saveOrUpdate(user);
		return "redirect:/welcome";
	}

	/**
	 * Admin User Login Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adminWelcome", method = RequestMethod.GET)
	public String getAdminWelcomePage(Model model) {
		return "adminHomepage";
	}

	/**
	 * Normal User Login Page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcomePage(Model model) {
		return "normalUserHomepage";
	}

	
	/**
	 * Logout Page which invalid HttpSession.
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

}
