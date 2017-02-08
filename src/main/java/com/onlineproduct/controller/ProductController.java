package com.onlineproduct.controller;

import java.io.File;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ServletContext servletContext;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getIndex(@ModelAttribute("product") Product product) {
		return "addProduct";
	}

	@RequestMapping(value = "/productDetails/{productId}", method = RequestMethod.GET)
	public String showDetailsProductPage(Model model, @PathVariable("productId") int productId) {
		model.addAttribute("product", productService.getProductById(productId));

		return "adminProductDetailsPage";

	}

	@RequestMapping(value = "/deleteProduct/{productId}", method = RequestMethod.GET)
	public String processDeleteProduct(Model model, @PathVariable("productId") int productId) {
		productService.deleteProduct(productId);

		return "redirect:/adminWelcome";

	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
	public String getEditProduct(@PathVariable("productId") int productId, Model model) {

		model.addAttribute("product", productService.getProductById(productId));
		return "editProduct";

	}

	@RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.POST)
	public String processEditProduct(@ModelAttribute("product") Product product,
			@PathVariable("productId") int productId, Model model) {
		productService.updateProduct(product, productId);
		return "redirect:/adminWelcome";

	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String processAddProductForm(@ModelAttribute("product") Product product, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");

		int userId = userService.findLoggedInUserId(user);
		product.setUserId(userId);

		MultipartFile productImage = product.getImage();

		/**
		 * random String generated code
		 */
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();

		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String randomStringGen = salt.toString();

		String all = servletContext.getRealPath("/");
		String half = all.substring(all.indexOf("/"), all.indexOf("/.metadata"));

		String path = half + servletContext.getContextPath() + "/src/main/webapp/assets/img/" + randomStringGen
				+ ".png";

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		product.setImageName(randomStringGen);

		productService.addProduct(product);
		return "redirect:/adminWelcome";
	}

	@RequestMapping(value = "/productDetail/{productId}", method = RequestMethod.GET)
	public String showProductDetail(Model model, @PathVariable("productId") int productId) {
		model.addAttribute("product", productService.getProductById(productId));

		return "normalProductDetailsPage";

	}
}
