package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.User;
import com.portfolio.repository.UserRepo;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	
	@Override
	public List<User> getAllUser() {

		return repo.getAllUser();
	}

	@Override
	public User insertUser(User u) {

		return repo.insertUser(u);
	}

	@Override
	public User updateUser(User u) {

		return repo.updateUser(u);
	}

	@Override
	public User deleteUser(User u) {

		return repo.deleteUser(u);
	}

	@Override
	public List<User> getUserFindByName(String email) {

		return repo.getUserFindByName(email);
	}

}
