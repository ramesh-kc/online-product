package com.onlineproduct.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineproduct.domain.Product;
import com.onlineproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}

	@Override
	public List<Map<String, Object>> getAllProducts() {
			return productRepository.getAllProducts();
	}

	@Override
	public Product getProductById(int productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteProduct(productId);
		
	}

	@Override
	public void updateProduct(Product product, int productId) {
		productRepository.updateProduct(product, productId);
		
	}

}
