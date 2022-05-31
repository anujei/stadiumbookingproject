package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;
@Service
public class CategoriesService {
	@Autowired
	CategoryDao categoryDao;
	

	public Category create(Category category)
	{
		return categoryDao.save(category); 
	}
	public Iterable<Category> select() {
        return categoryDao.findAll();
    }
	

	public void delete(int Categoryid) {
		categoryDao.deleteById(Categoryid);
		}
	
	public void Update(Category category)
	{
		categoryDao.save(category); 
	}
}
