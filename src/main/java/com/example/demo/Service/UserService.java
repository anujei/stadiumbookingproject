package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Model.User;

@Service
public class UserService{
	
	@Autowired
	UserDao userDao;
	public User createUser(User user)
	{
		return userDao.save(user); 
	}

	public Iterable<User> findAll() {
        return userDao.findAll();
    }
		
	public void deleteById(int Userid) {
		userDao.deleteById(Userid);
		}
	
	public void UpdateUser(User user)
	{
		 userDao.save(user); 
	}
	
}
