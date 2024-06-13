package com.Mouad.CineBase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mouad.CineBase.model.User;
import com.Mouad.CineBase.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/add")
	public User create(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	@GetMapping("/read")
	public List<User> read(){ 
		return userService.getAllUsers(); 
	}
	  
	@PutMapping("/update/{id}")
	public User update(@PathVariable Long id, @RequestBody User user) { 
		return userService.edit(id, user);
	  }
	  
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id); 
	}
	
	 
	
}
