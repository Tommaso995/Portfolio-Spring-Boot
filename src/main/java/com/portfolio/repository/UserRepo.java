package com.portfolio.repository;

import java.util.List;

import com.portfolio.entity.User;

public interface UserRepo {

	List<User> getAllUser();
	
	User insertUser(User u);
	
	User updateUser(User u);
	
	User deleteUser(User u);
	
	List<User> getUserFindByName(String email);
}
