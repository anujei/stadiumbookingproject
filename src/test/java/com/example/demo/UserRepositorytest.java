package com.example.demo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositorytest {
//	@Autowired
//	private UserService service;
	
	@Autowired
	private UserDao userdao;
	
	@Test
	public void getUserTest() {
		 
		User user = userdao.findById("anuj").get();
		Assertions.assertThat(user.getUserName()).isEqualTo("anuj");
	}
	@Test
	public void getUserListTest() {
		List<User> user = userdao.findAll();
		Assertions.assertThat(user.size()).isGreaterThan(0);
	}
}
