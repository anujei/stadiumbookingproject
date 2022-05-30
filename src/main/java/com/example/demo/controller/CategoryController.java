package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoriesService;

public class CategoryController {
	@Autowired
	private CategoriesService categoriesService;
	
	@PostMapping("/createEvent")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<Category> createEvent(@RequestBody Category category)
	{
		categoriesService.createCategory(category); 
		return new ResponseEntity<Category>(categoriesService.createCategory(category),HttpStatus.CREATED);
	}
	 @GetMapping("/viewEvent")
	 @PreAuthorize("hasAnyRole('Admin','User')")
	 public Iterable<Category> viewEvent(){
	        return categoriesService.findAll();
	 }
	 
	 @DeleteMapping("/deleteEvent/{id}")
	 @PreAuthorize("hasRole('Admin')")
	 public void deleteEvent(@PathVariable("Categoryid") int id) {
		 categoriesService.deleteEvent(id);
	 }

}
