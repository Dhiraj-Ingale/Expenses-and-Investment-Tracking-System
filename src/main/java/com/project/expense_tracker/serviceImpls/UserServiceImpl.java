package com.project.expense_tracker.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.repositories.UserRepository;
import com.project.expense_tracker.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	// Constructor
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	// Function : Get user by userId.
	public User getUserById(long userId) {
		return userRepository.getById(userId);
	}
	
	// Function : Get user by username.
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	// Function : Save User 
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
