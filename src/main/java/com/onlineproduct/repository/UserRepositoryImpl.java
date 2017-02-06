package com.onlineproduct.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;



import com.onlineproduct.domain.User;

public class UserRepositoryImpl implements UserRepository {

	private JdbcTemplate jdbcTemplate;
	
	public UserRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User user) {
		String sql = "INSERT INTO users (username, password, name, email, contact, address, dateOfBirth)" 
						+ "Values(?, ?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, user.getUsername(),user.getPassword(), user.getName(), 
				user.getEmail(), user.getContact(), user.getAddress(), user.getDateOfBirth());
		
	}

	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		return null;
	}

}
