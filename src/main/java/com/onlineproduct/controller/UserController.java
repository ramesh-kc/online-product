package com.onlineproduct.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onlineproduct.domain.User;
import com.onlineproduct.service.ProductService;
import com.onlineproduct.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndexPage() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("user") User user) {
		return "index";
	}

	 @InitBinder
	 public void initBinder(final WebDataBinder binder){
	 final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	 true));
	 }

	/**
	 * login authentication for normal user and admin user
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginProcessForm(@ModelAttribute("user") User user, boolean remember,
			@CookieValue(value = "username", defaultValue = "") String username, Model model, HttpSession session,
			HttpServletResponse response, RedirectAttributes redirectAttribute) {

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
			session.setAttribute("userName", userInfo.getUsername());

			if (isAdmin) {
				return "redirect:/adminWelcome";

			} else {
				return "redirect:/welcome";
			}

		} else {
			redirectAttribute.addFlashAttribute("errorMessage", "Invalid Username or Password");
			return "redirect:/index";
		}
	}

	/**
	 * User Registration get method which display registration form.
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String getUserRegistration(@ModelAttribute("user") User user) {
		return "userRegistration";
	}

	/**
	 * User Registration Post Method
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String processUserLoginForm(@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpSession session) {

		System.out.println("User Object: " + user);

		if (result.hasErrors()) {
			return "userRegistration";
		}

		userService.saveOrUpdate(user);
		session.setAttribute("userName", user.getUsername());

		session.setAttribute("userInfo", user);
		
		System.out.println("User Status"+user.getStatus());

		if (user.getStatus().equals("Admin"))
			return "redirect:/adminWelcome";
		else
			return "redirect:/welcome";
	}

	/**
	 * Admin User Login Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adminWelcome", method = RequestMethod.GET)
	public String getAdminWelcomePage(Model model) {

		for (Map<String, Object> row : productService.getAllProducts()) {
		}
		;

		model.addAttribute("productList", productService.getAllProducts());
		return "adminHomepage";
	}

	/**
	 * Normal User Login Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcomePage(Model model) {

		for (Map<String, Object> row : productService.getAllProducts()) {
		}
		;

		model.addAttribute("productList", productService.getAllProducts());

		return "normalUserHomepage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String loginRequired(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

}
