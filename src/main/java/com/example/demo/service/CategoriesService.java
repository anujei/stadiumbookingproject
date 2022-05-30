package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;

public class CategoriesService {
	@Autowired
	CategoryDao categorydao;
	
	public Category createCategory(Category category)
	{
		return categorydao.save(category); 
	}
	public Iterable<Category> findAll() {
        return categorydao.findAll();
    }
	public void deleteEvent(int Categoryid) {
		categorydao.deleteById(Categoryid);
	}
}
