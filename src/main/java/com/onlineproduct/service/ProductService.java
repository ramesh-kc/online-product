package com.onlineproduct.service;

import java.util.List;
import java.util.Map;

import com.onlineproduct.domain.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	
	public List<Map<String, Object>> getAllProducts();
	
	public Product getProductById(String productId);
}
