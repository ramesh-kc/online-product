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

}
