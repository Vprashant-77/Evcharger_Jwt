package com.example.jwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostConstruct
	public void initRolesAndUsers() {
		
		userService.initRolesAndUser();
	}
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}
	
	
	@GetMapping({"/forAdmin"})
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		
		return "this url is accesible to only Admin";
	}
	
	
	@GetMapping({"/forUser"})
	@PreAuthorize("hasAnyRole('User',Admin)")
	public String forUser() {
		
		return "this url is accesible to only general User";
	}
}

