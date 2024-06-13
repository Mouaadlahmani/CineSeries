package com.Mouad.CineBase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mouad.CineBase.model.User;
import com.Mouad.CineBase.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	@Override 
	public List<User> getAllUsers() { 
		return userRepository.findAll();
	}
	  
	@Override 
	public User edit(Long id, User user) { 
	  user.setUserId(id); 
	  return userRepository.save(user); 
	}
	  
	@Override 
	public void delete(Long id) { 
		userRepository.deleteById(id); 
	}
	  
	@Override public User getById(Long id) { 
	  return userRepository.findById(id).orElse(null); 
	}
	 


}
