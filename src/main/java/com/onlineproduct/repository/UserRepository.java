package com.onlineproduct.repository;


import com.onlineproduct.domain.User;

public interface UserRepository {
	
	public void saveOrUpdate(User user);
	
	public boolean authenticateUser(User user);
	
	public boolean isAdmin(User user);
	
	public User findLoggedInUserInfo(String username, String password);
	
	public int findLoggedInUserId(User user);

}
