package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
class StadiumdemoApplicationTests {

	@Autowired
	private UserService service;
	
	@MockBean
	private UserDao userdao;
	
	@Test
	public void getUserTest() {
		when(userdao.findAll()).thenReturn(Stream.of(new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", 9, "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",null,null)).collect(Collectors.toList()));
		assertEquals(1,((List<User>) service.findAll()).size());
	}
	@Test
	public void insertUserTest()
	{
		User user = new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", 9, "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",null,null);
		when(userdao.save(user)).thenReturn(user);
		assertEquals(user, service.registerNewUser(user));
	}
	@Test
	public void deleteUser()
	{
		User user  = new User("anuj", "anuj", "Anuj", "Anuj@gmail.com", 9, "11032000", "dfgfhg",5465656,"Gujarat","Ahmedabad",null,null);
		userdao.delete(user);
		verify(userdao,times(1)).delete(user);
	}
//	@Test
//	void contextLoads(){
//		
//	}
}

