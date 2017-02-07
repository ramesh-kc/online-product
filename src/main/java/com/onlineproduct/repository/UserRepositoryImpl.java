package com.onlineproduct.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineproduct.domain.User;
@Repository
public class UserRepositoryImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveOrUpdate(User user) {
		int sex = 0;
		if (user.getSex().equals("Male")) {
			sex = 1;
		}
		String sql = "INSERT INTO users (username, password, name, sex, email, contact, address, dateOfBirth)" 
						+ "Values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, user.getUsername(),user.getPassword(), user.getName(), 
				sex, user.getEmail(), user.getContact(), user.getAddress(), user.getDateOfBirth());
		
	}

	@Override
	public boolean authenticateUser(User user) {
		boolean userExists = false;
		
		String sql = "SELECT count(*) FROM users where username = ? and password = ?";
						
		int rowCount = jdbcTemplate.queryForObject(sql, 
				new Object[]{user.getUsername(), user.getPassword()},  Integer.class);
		
		
		if(rowCount == 1) {
			userExists = true;
		}
		
		return userExists;
	}

	
}
