package com.onlineproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineproduct.domain.User;
import com.onlineproduct.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveOrUpdate(User user) {
		userRepository.saveOrUpdate(user);
		
	}

	@Override
	public boolean authenticateUser(User user) {
		return userRepository.authenticateUser(user);
	}

	@Override
	public User findLoggedInUserInfo(String username, String password) {
		return userRepository.findLoggedInUserInfo(username, password);
	}

	@Override
	public int findLoggedInUserId(User user) {
		return userRepository.findLoggedInUserId(user);
	}

	@Override
	public boolean isAdmin(User user) {
		return userRepository.isAdmin(user);
	}

}
