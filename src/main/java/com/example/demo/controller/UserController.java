package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.security.access.prepost.PreAuthorize;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }
	
//	@GetMapping({"/forAdmin"})
//    @PreAuthorize("hasRole('Admin')")
//    public String forAdmin(){
//        return "This URL is only accessible to the admin";
//    }
//
//    @GetMapping({"/forUser"})
//    @PreAuthorize("hasRole('User')")
//    public String forUser(){
//        return "This URL is only accessible to the user";
//    }
	
	
    // User controllers
	//create and update	
	@GetMapping("/viewUser")
	@PreAuthorize("hasRole('Admin')")
	 public Iterable<User> viewUser(){
	        return userService.findAll();
	  }
	
	 @DeleteMapping("/deleteUser/{Userid}")
	 @PreAuthorize("hasRole('Admin')")
	 public void deleteUser(@PathVariable("Userid") String EmailId) {
		 userService.deleteById(EmailId);
	 }
	 
	 @PostMapping("/UpdateUser")
	 @PreAuthorize("hasAnyRole('User','Admin')")
	 public User UpdateUser(@RequestBody User user) {
		userService.UpdateUser(user);
		return user;
	 }
	 // end of user controller
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
}
