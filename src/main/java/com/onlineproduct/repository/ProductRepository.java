package com.onlineproduct.repository;

import java.util.List;
import java.util.Map;

import com.onlineproduct.domain.Product;

public interface ProductRepository {
	
	public void addProduct(Product product);
	
	public List<Map<String, Object>> getAllProducts();
	
	public Product getProductById(int productId);
	
	public void deleteProduct(int productId);
}
