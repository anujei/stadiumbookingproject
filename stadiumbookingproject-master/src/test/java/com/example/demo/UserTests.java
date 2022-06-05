 package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@SpringBootTest
public class UserTests {
	@Autowired
	private UserService service;
	@MockBean
	private UserDao userDao;

	
	
	@Test
	public void getUserTest()
	{
		when(userDao.findAll()).thenReturn(Stream.of(new User("Aditi", "aditi@gmail.com", "abcd", "Aditi",953796715, "2-1-2020", "Address", 364001, "guj", "bvn",new Role ("User","user Default"),new OrderDetail(1, 20, 200, "COD", "Available") )).collect(Collectors.toList()));
		assertEquals(1,((List<User>) service.getUser()).size());
		
	}
	
	
	
	
	@Test
	public void insertUserTest()
	{
		// add Role
		Role adminRole = new Role("User","User Role");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		
		//add Order details
		OrderDetail orderdetail = new OrderDetail(1, 20, 200, "COD", "Acitve");
		Set<OrderDetail> orderset = new HashSet<>();
		orderset.add(orderdetail);
		
		// Register new User
		User user = new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", 942950, "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",adminRoles,orderset);
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user, service.registerNewUser(user));
	}

	
	@Test 
	public void deleteUserTest() {
		
		service.deleteUser("anuj");
		verify(userDao, times(1)).deleteById("anuj");
	}
	@Test
	public void updateUserTest() {
		User user = new User("Aditi", "aditi@gmail.com", "abcd", "aditi",953796715, "2-1-2020", "Address", 364001, "guj", "bvn",new Role ("User","user Default"),new OrderDetail(1, 20, 200, "COD", "Available"));
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user, service.UpdateUser(user));
	}
	

	

}
