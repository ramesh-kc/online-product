package com.onlineproduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.onlineproduct.domain.Product;


@Controller
public class ProductController {
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("product") Product product) {
		return "addProduct";
	}
}
