package com.portfolio.service;

import java.util.List;

import com.portfolio.entity.User;

public interface UserService {

	List<User> getAllUser();
	
	User insertUser(User u);
	
	User updateUser(User u);
	
	User deleteUser(User u);
	
	List<User> getUserFindByName(String name);
	
}
