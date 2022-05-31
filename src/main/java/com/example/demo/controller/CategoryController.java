package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;

import com.example.demo.service.CategoriesService;

@RestController
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoriesService categoryService;
	//create and update
	@PostMapping("/createCategory")
	public ResponseEntity<Category> createCategory(@RequestBody Category category)
	{
		categoryService.create(category); 
		return new ResponseEntity<Category>(categoryService.create(category),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewCategory")
	 public Iterable<Category> viewCategory(){
	        return categoryService.select();
	  }
	
	 @DeleteMapping("/deleteCategory/{Categoryid}")
	 public void deleteCategory(@PathVariable("Categoryid") int Categoryid) {
		 categoryService.delete(Categoryid);
	 }
	 
	 @PostMapping("/UpdateCategory")
	 
	 public Category UpdateCategory(@RequestBody Category category) {
		 categoryService.Update(category);
		return category;
	 }
	
	
}
