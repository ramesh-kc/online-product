package com.onlineproduct.service;

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

}
