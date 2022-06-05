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

import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.EventDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.Event;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.EventService;

@SpringBootTest
public class CategoryTests {
	@Autowired
	private CategoriesService service;
	@MockBean
	private CategoryDao categoryDao;
	
	@Test
	public void findAllACategoryTest()
	{
		when(categoryDao.findAll()).thenReturn(List.of(new Category(1, "Platinum", 200, false, 10,new OrderDetail(1, 20, 200, "Gpay", "Available" ))));
		
		
		assertEquals(1,((List<Category>) service.select()).size());
	}
	
	@Test
	public void insertCategoryTest()
	{
		Category category  = new Category(1, "Platinum", 200, false, 10,new OrderDetail(1, 20, 200, "Gpay", "Available" ));
		when(categoryDao.save(category)).thenReturn(category);
		assertEquals(category, service.create(category));
	}

	@Test
	public void DeleteCategoryTest() {
		service.delete(1);
		verify(categoryDao, times(1)).deleteById(1);
		
	}
	
	@Test
	public void UpdateCategoryTest()
	{
		Category category  = new Category(1, "Silver", 100, false, 10,new OrderDetail(1, 20, 200, "Gpay", "Available" ));
		when(categoryDao.save(category)).thenReturn(category);
		assertEquals(category, service.Update(category));
	}
	
	
	

}
