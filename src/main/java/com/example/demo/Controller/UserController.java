package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;


@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	//create and update
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		userService.createUser(user); 
		return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewUser")
	 public Iterable<User> viewUser(){
	        return userService.findAll();
	  }
	
	 @DeleteMapping("/deleteUser/{Userid}")
	 public void deleteUser(@PathVariable("Userid") int Userid) {
		 userService.deleteById(Userid);
	 }
	 
	 @PostMapping("/UpdateUser")
	 
	 public User UpdateUser(@RequestBody User user) {
		userService.UpdateUser(user);
		return user;
	 }

}
	