package com.project.expense_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.services.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") long userId) throws Exception {
		User user = userService.getUserById(userId);
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/users/u-{username}")
	public ResponseEntity<User> getUserByName(@PathVariable("username") String username) throws Exception {
		User user = userService.getUserByUsername(username);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/validate-user")
	public ResponseEntity<Boolean> validateUser(@RequestBody User user) throws Exception {
		boolean isValid = false;
		System.out.println(user);
		User u = userService.getUserByUsername(user.getUsername());
		if(u.getPassword().equals(user.getPassword()))
			isValid = true;
		return ResponseEntity.ok().body(isValid);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUSer(@RequestBody User user)  throws Exception {
		User u = userService.saveUser(user);
		return ResponseEntity.ok().body(u);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") long userId, @RequestBody User user) throws Exception {
		User u = userService.getUserById(userId);
		u.setCurrency(user.getCurrency());
		u.setEmail(user.getEmail());
		u.setMobno(user.getMobno());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		userService.saveUser(u);
		return ResponseEntity.ok().body(u);
	}

}
