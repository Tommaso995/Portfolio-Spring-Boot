package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.User;
import com.portfolio.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService user$;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> entity = user$.getAllUser();
		
		return new ResponseEntity<List<User>>(entity, HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<User> inserUser(@RequestBody User user){
		
		User u = user$.insertUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		
		User u = user$.updateUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<User> deleteUser(@RequestBody User user){
		
		User u = user$.deleteUser(user);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
		
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable String email){
		
		List<User> list = user$.getUserFindByName(email);
		
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
}
