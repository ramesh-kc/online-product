package com.onlineproduct.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Autowired
    private ResourceLoader resourceLoader;
	
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
		
		MultipartFile productImage = product.getImage();
		System.out.println("Image: " + productImage);
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println("root: " + rootDirectory);
			
		//isEmpty means file exists BUT NO Content
			if (productImage != null && !productImage.isEmpty()) {
		       try {
		    	   System.out.println("before: " + rootDirectory+"assets/img/"+ product.getName()+ ".png");
		    	   
		      	productImage.transferTo(new File(rootDirectory +"assets/img"+ prooduct.getName()+ ".png"));
		       } catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }

			System.out.println("Image Info:" + productImage);
		
		productService.addProduct(product);
		return "redirect:/adminWelcome";
	}
}
