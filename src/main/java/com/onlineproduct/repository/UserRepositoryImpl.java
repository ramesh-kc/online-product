package com.onlineproduct.repository;

import java.util.List;


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
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

}
