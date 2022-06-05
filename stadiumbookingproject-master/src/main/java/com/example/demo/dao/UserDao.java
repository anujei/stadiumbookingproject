package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
//	User findByUsername(String Username);
//	@Query("SELECT u FROM User u WHERE u.EmailId = :EmailId")
//	List<User> findByEmailId(String EmailId);
//	List<User> findByEmailId(String EmailId);

}
