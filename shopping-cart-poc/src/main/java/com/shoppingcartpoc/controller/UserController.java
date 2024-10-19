package com.shoppingcartpoc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartpoc.model.User;
import com.shoppingcartpoc.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/user")
public class UserController {
	private UserService service;
	public UserController(UserService service) {
		this.service=service;
	}
	 
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return service.getUsers();
	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return service.getUserById(id);
	}
	@PostMapping("/signUp")
	public User addTheUser(@RequestBody User user) {
		return service.addUser(user);
	}
	@PutMapping("update/{id}")
	public User updateTheUser(@PathVariable Long id,@RequestBody User user) {
		return service.updateUser(id, user);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTheUser(@PathVariable Long id) {
		service.getUserById(id);
		service.deleteUser(id);
	}
	
	
}
