package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	RoleRepo repo;
	
	public Role createRole(Role role) {
		
		return repo.save(role);
	}
}
