package com.project.expense_tracker.services;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.User;

@Service
public interface UserService {
	
	public User getUserById(long userId);
	
	public User getUserByUsername(String username);
	
	public User saveUser(User user);

}
