package com.onlineproduct.service;

import com.onlineproduct.domain.User;

public interface UserService {
	public void saveOrUpdate(User user);
	
	public boolean authenticateUser(User user);
}
