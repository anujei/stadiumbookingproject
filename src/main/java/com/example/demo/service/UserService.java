package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User register(User user)
	{
		return userRepo.save(user);
	}
	
	public void initRolesAndUsers()
	{
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin Role");
		roleRepo.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("User Role");
		roleRepo.save(userRole);
		
		User adminUser = new User();
		adminUser.setEmail("Admin@gmail.com");
		adminUser.setUserName("Admin");
		adminUser.setPassword(getEncodedPassword("Admin@1234"));
		adminUser.setAddress("shivganesh society");
		adminUser.setCity("Ahemdabad");
		adminUser.setDOB("04-01-2001");
		adminUser.setMobileNo("9537967153");
		adminUser.setState("Guj");
		adminUser.setPincode(364001);
		
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);
		
		
		User user = new User();
		user.setEmail("Aditi@gmail.com");
		user.setUserName("Aditi");
		user.setPassword(getEncodedPassword("Aditi@1234"));
		user.setAddress("sola bridge");
		user.setCity("Ahemdabad");
		user.setDOB("01-01-2001");
		user.setMobileNo("9974715324");
		user.setState("Guj");
		user.setPincode(364001);
		
		Set <Role> UserRoles = new HashSet<>();
		UserRoles.add(userRole);
		user.setRole(UserRoles);
		
		userRepo.save(user);
		
	}
	public String getEncodedPassword(String Password)
	{
		return passwordEncoder.encode(Password);
	}
}
