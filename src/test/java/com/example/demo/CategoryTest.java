//package com.example.demo;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.example.demo.dao.CategoryDao;
//import com.example.demo.entity.Category;
//import com.example.demo.entity.OrderDetail;
//import com.example.demo.entity.Role;
//import com.example.demo.service.CategoriesService;
//
//@SpringBootTest
//public class CategoryTest {
//	@Autowired
//	private CategoriesService service;
//	@MockBean
//	private CategoryDao categoryDao;
//	
//	@Test
//	public void findAllACategoryTest()
//	{
//		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
//		Set<OrderDetail> orderdetailset = new HashSet<>();
//		orderdetailset.add(orderdetails);
//		when(categoryDao.findAll()).thenReturn(List.of(new Category(1, "Platinum", 200f, false, 10,orderdetailset)));
//		
//		
//		assertEquals(1,((List<Category>) service.select()).size());
//	}
//	
//	@Test
//	public void insertCategoryTest()
//	{
//		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
//		Set<OrderDetail> orderdetailset = new HashSet<>();
//		orderdetailset.add(orderdetails);
//		Category category  = new Category(1, "Platinum", 200f, false, 10,orderdetailset);
//		when(categoryDao.save(category)).thenReturn(category);
//		assertEquals(category, service.create(category));
//	}
//
//	@Test
//	public void DeleteCategoryTest() {
//		service.delete(1);
//		verify(categoryDao, times(1)).deleteById(1);
//		
//	}
//	
//	@Test
//	public void UpdateCategoryTest()
//	{
//		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
//		Set<OrderDetail> orderdetailset = new HashSet<>();
//		orderdetailset.add(orderdetails);
//		Category category  = new Category(1, "Platinum", 200f, false, 10,orderdetailset);
//		when(categoryDao.save(category)).thenReturn(category);
//		assertEquals(category, service.Update(category));
//	}
//	
//	
//	
//
//}
