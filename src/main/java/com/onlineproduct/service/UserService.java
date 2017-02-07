package com.onlineproduct.service;

import com.onlineproduct.domain.User;

public interface UserService {
	public void saveOrUpdate(User user);
	
	public boolean authenticateUser(User user);
	
	public User findLoggedInUserInfo(String username, String password);
	
	public int findLoggedInUserId(User user);
}
