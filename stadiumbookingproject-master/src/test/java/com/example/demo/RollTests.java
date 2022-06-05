package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.Event;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@SpringBootTest
public class RollTests {
	@Autowired
	private RoleService service;
	@MockBean
	private RoleDao roleDao;
	
	
	
	@Test
	public void insertRoleTest()
	{
		Role role  = new Role("User", "Default");
		when(roleDao.save(role)).thenReturn(role);
		assertEquals(role, service.createNewRole(role));
	}
	
	
}
