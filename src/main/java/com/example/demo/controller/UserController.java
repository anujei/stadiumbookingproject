package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostConstruct
	public void initRolesAndUsers()
	{
		service.initRolesAndUsers();
	}
	
	@PostMapping("/register")
	public User register (@RequestBody User user)
	{
		return service.register(user);
	}
	
	@GetMapping("/forAdmin")
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin()
	{
		return "this is only accessible to Admin";
	}
	@GetMapping("/forUser")
	@PreAuthorize("hasRole('User')")
	public String forUser()
	{
		return "this is only accessible to User";
	}
}
