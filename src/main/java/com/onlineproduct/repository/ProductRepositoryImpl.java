package com.onlineproduct.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineproduct.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void addProduct(Product product) {
		String sql = "INSERT into products(name, userId, imageName, price, dateManufacture, "
				+ "category, description)"
					+ "Values(?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, product.getName(), product.getUserId(), product.getImageName(), product.getPrice(),
				product.getDateManufacture(), product.getCategory(), product.getDescription());
	}

	@Override
	public List<Map<String, Object>> getAllProducts() {
		String sql = "SELECT * FROM products LIMIT 3";
		
		List<Map<String, Object>> products = jdbcTemplate.queryForList(sql);
		return products;
		
	}

	@Override
	public Product getProductById(String productId) {
		String sql = "SELECT * FROM products WHERE productId = ?";
		
		Product product =  (Product) jdbcTemplate.queryForObject(sql,
				new Object[] {productId}, 
				new BeanPropertyRowMapper<>(Product.class));
		
		return product;
	}
	
}
