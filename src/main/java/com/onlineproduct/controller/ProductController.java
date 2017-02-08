package com.onlineproduct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineproduct.domain.Product;
import com.onlineproduct.domain.User;
import com.onlineproduct.service.ProductService;
import com.onlineproduct.service.UserService;


@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("product") Product product) {
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST) 
	public String processAddProductForm(@ModelAttribute("product") Product product, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");
		
		int userId  =  userService.findLoggedInUserId(user);
		product.setUserId(userId);
		
		productService.addProduct(product);
		return "redirect:/adminWelcome";
	}
}
