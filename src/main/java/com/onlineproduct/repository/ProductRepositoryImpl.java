package com.onlineproduct.repository;

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
		String userId = "";
		String sql = "INSERT into products(name, userId, image, price, dateManufacture, "
				+ "category, description)"
					+ "Values(?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, product.getName(), userId, product.getImage(), product.getPrice(),
				product.getDateManufacture(), product.getCategory(), product.getDescription());
	}

}
