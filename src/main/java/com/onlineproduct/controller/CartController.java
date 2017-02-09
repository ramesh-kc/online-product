package com.onlineproduct.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.onlineproduct.domain.Cart;
import com.onlineproduct.domain.CartItem;
import com.onlineproduct.domain.Product;
import com.onlineproduct.service.CartService;
import com.onlineproduct.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public String get(HttpServletRequest request) {
		return "redirect:/cart/"+request.getSession(true).getId();
	}
	
	
	@RequestMapping(value = "/cart/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
		
		model.addAttribute("cartId",cartId);
		
		System.out.println("CART ID: "+ cartId);
		
		Cart cart = cartService.read(cartId);
		if (cart == null) {
			cart = new Cart(cartId);
			cartService.create(cart );
		}
		model.addAttribute("cart",cart);
		
		return "userCart";
	}
	
	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addToCart(@PathVariable("productId") String productId,HttpServletRequest request){
		System.out.println("INSIDE "+productId);
		
		String sessionId = request.getSession(true).getId();
		
		System.out.println("SessionID: "+sessionId);
		
		Cart cart = cartService.read(sessionId);
		if(cart== null) {
			cart = cartService.create(new Cart(sessionId));
		}
		
		Product product = productService.getProductById(Integer.parseInt(productId));
		if(product == null) {
			throw new IllegalArgumentException("Error : Product Not Found");
		}
		
		cart.addCartItem(new CartItem(product));
		
		
		System.out.printf("Product ITEM: %s\n",product.getName());
		System.out.printf("CART ITEM: %s\n",cart.getCartItems().size());
	
		cartService.update(sessionId, cart);
		
	}
	
	
	@RequestMapping(value = "/removeFromCart/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String productId, HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if(cart== null) {
			cart = cartService.create(new Cart(sessionId));
		}
		
		Product product = productService.getProductById(Integer.parseInt(productId));
		if(product == null) {
			throw new IllegalArgumentException("Error : Product Not Found");
		}

		cart.removeCartItem(new CartItem(product));
				
		cartService.update(sessionId, cart);
	}

}
