package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

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