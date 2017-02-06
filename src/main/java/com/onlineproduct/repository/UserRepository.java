package com.onlineproduct.repository;

import java.util.List;

import com.onlineproduct.domain.User;

public interface UserRepository {

	public void saveOrUpdate(User user);

	public List<User> userList();

}
