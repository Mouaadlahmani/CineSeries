package com.Mouad.CineBase.service;

import java.util.List;


import com.Mouad.CineBase.model.User;

public interface UserService {
	
	public User createUser(User user);
	public List<User> getAllUsers(); 
	public User edit(Long id, User user); 
	public void delete(Long id); public User getById(Long id);
	 
	
}
