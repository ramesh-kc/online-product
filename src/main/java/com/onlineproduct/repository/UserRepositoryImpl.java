package com.onlineproduct.repository;

import java.security.MessageDigest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		
		String passwordmd = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(user.getPassword().getBytes());
			byte[] digest = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			passwordmd = sb.toString();
			
			int sex = 0;
			if (user.getSex().equals("Male")) {
				sex = 1;
			}
			String sql = "INSERT INTO users (username, password, name, sex, email, contact, address, dateOfBirth)" 
							+ "Values(?, ?, ?, ?, ?, ?, ?, ?)";
			
			jdbcTemplate.update(sql, user.getUsername(), passwordmd, user.getName(), 
					sex, user.getEmail(), user.getContact(), user.getAddress(), user.getDateOfBirth());
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public boolean authenticateUser(User user) {
		boolean userExists = false;
		
		String passwordmd = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(user.getPassword().getBytes());
			byte[] digest = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			passwordmd = sb.toString();
			
			String sql = "SELECT count(*) FROM users where username = ? and password = ?";
							
			int rowCount = jdbcTemplate.queryForObject(sql, 
					new Object[]{user.getUsername(), passwordmd},  Integer.class);
			
			if(rowCount == 1) {
				userExists = true;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return userExists;
	}

	@Override
	public User findLoggedInUserInfo(String username, String password) {
		String passwordmd = "";
		User user = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			passwordmd = sb.toString();
			
			String sql = "SELECT * FROM users where username = ? and password = ?";
			
			user = (User) jdbcTemplate.queryForObject(
					sql, new Object[]{ username, passwordmd}, 
					new BeanPropertyRowMapper<>(User.class));
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return user;
	}

	
	/**
	 * find user id for each specific user
	 */
	@Override
	public int findLoggedInUserId(User user) {
		int userId = 0;
		
		try {		
			String sql = "SELECT id FROM users where username = '"+user.getUsername()+"'";
			
			userId =  jdbcTemplate.queryForObject(
					sql, Integer.class);
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return userId;
		
	}

	
}
