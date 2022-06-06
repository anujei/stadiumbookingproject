package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositorytest {
	@Autowired
	private UserService service;
	
	@MockBean
	private UserDao userdao;
	
	@Test
	public void getUserTest() {
		Role adminRole = new Role("User","User Role");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		
		//add Order details
		OrderDetail orderdetail = new OrderDetail(1, 20, 200, "COD", 0);
		Set<OrderDetail> orderset = new HashSet<>();
		orderset.add(orderdetail);
		when(userdao.findAll()).thenReturn(Stream.of(new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", "9429506934", "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",adminRoles,orderset)).collect(Collectors.toList()));
		assertEquals(1,((List<User>) service.findAll()).size());
	}
	@Test
	public void insertUserTest()
	{
		// add Role
		Role adminRole = new Role("User","User Role");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		
		//add Order details
		OrderDetail orderdetail = new OrderDetail(1, 20, 200, "COD", 0);
		Set<OrderDetail> orderset = new HashSet<>();
		orderset.add(orderdetail);
		
		// Register new User
		User user = new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", "9429506934", "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",adminRoles,orderset);
		when(userdao.save(user)).thenReturn(user);
		assertEquals(user, service.registerNewUser(user));
	}
	@Test
	public void deleteUser()
	{
		service.deleteById("anuj");
		verify(userdao, times(1)).deleteById("anuj");
	}
	@Test
	public void updateUserTest() {
		// add Role
		Role adminRole = new Role("User","User Role");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		
		//add Order details
		OrderDetail orderdetail = new OrderDetail(1, 20, 200, "COD", 0);
		Set<OrderDetail> orderset = new HashSet<>();
		orderset.add(orderdetail);		
		User user = new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", "9429506934", "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",adminRoles,orderset);
		when(userdao.save(user)).thenReturn(user);
		assertEquals(user, service.UpdateUser(user));
	}
}
