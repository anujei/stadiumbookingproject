package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
    private PasswordEncoder passwordEncoder;
//	public User registerNewUser(User user) {
//		return userdao.save(user);
//	}
	
	 public void initRoleAndUser() {
		 Role adminRole = new Role();
	     adminRole.setRoleName("Admin");
	     adminRole.setRoleDescription("Admin role");
	     roleDao.save(adminRole);
	     
	     Role userRole = new Role();
	     userRole.setRoleName("User");
	     userRole.setRoleDescription("User Role");
	     roleDao.save(userRole);
	     
	     User adminUser = new User();
	     adminUser.setUserName("admin@123");
	     adminUser.setName("admin123");
	     adminUser.setUserPassword(passwordEncoder.encode("abcd"));
//	     adminUser.setUserPassword("admin@pass");
	     adminUser.setEmailId("admin@gmail.com");
//	     adminUser.setId(1);
	     Set<Role> adminRoles = new HashSet<>();
	     adminRoles.add(adminRole);
	     adminUser.setRole(adminRoles);
	     userdao.save(adminUser);
	     
	 }
	 public User registerNewUser(User user) {
	        Role role = roleDao.findById("User").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

	        return userdao.save(user);
	    }
	 
	 @Bean
	 public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	 
	 //CRUD for user
		public Iterable<User> getUser() {
			 Iterable<User> users = userdao.findAll();
		//	 System.out.println("getting data from db:" + users);
			 
			 return users;
	      
			
			
	    }
			
		public void deleteUser(String username) {
			userdao.deleteById(username);
			}
		
		public User UpdateUser(User user)
		{
			return userdao.save(user); 
		}
	 
}
