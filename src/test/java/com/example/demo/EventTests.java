package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.EventDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.Event;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.EventService;

@SpringBootTest
public class EventTests {
	@Autowired
	private EventService service;
	@MockBean
	private EventDao eventDao;

	
	@Test
	public void findAllEventTest()
	{
		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
		Set<OrderDetail> orderdetailset = new HashSet<>();
		orderdetailset.add(orderdetails);
		Category category = new Category(1, "gold", 200f, false, 10, orderdetailset);
		Set<Category> categoryset = new HashSet<>();
		categoryset.add(category);
		
		when(eventDao.findAll()).thenReturn(List.of(new Event(1, "IPL", "IPL Cricket", "2-1-2020", true, "Venue",100,categoryset)));
		
		assertEquals(1,((List<Event>) service.findAll()).size());
	}
	
	@Test
	public void insertEventTest()
	{
		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
		Set<OrderDetail> orderdetailset = new HashSet<>();
		orderdetailset.add(orderdetails);
		Category category = new Category(1, "gold", 200f, false, 10, orderdetailset);
		Set<Category> categoryset = new HashSet<>();
		categoryset.add(category);
		Event event  = new Event(1, "IPL", "IPL Cricket", "2-1-2020", true, "Venue",100, categoryset);
		when(eventDao.save(event)).thenReturn(event);
		assertEquals(event, service.createEvent(event));
	}
	@Test
	public void DeleteEventTest() {
		service.deleteEvent(2);
		verify(eventDao, times(1)).deleteById(2);
		
	}
	@Test
	public void UpdateEventTest()
	{
		OrderDetail orderdetails = new OrderDetail(1, 20, 200f, "Gpay", 0);
		Set<OrderDetail> orderdetailset = new HashSet<>();
		orderdetailset.add(orderdetails);
		Category category = new Category(1, "gold", 200f, false, 10, orderdetailset);
		Set<Category> categoryset = new HashSet<>();
		categoryset.add(category);
		Event event  = new Event(1, "IPL", "IPL Cricket", "2-1-2020", true, "Venue",100, categoryset);
		when(eventDao.save(event)).thenReturn(event);
		assertEquals(event, service.Update(event));
	}
	
	
}