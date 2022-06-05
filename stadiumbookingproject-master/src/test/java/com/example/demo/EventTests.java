package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.EventDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Category;
import com.example.demo.entity.Event;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.EventService;
import com.example.demo.service.UserService;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EventTests {
	@Autowired
	private EventService service;
	@MockBean
	private EventDao eventDao;

	
	@Test
	public void findAllEventTest()
	{
		when(eventDao.findAll()).thenReturn(List.of(new Event(1, "IPL", "IPL Cricket", "2-1-2020", true, "Venue",100, new Category(1, "gold", 200, false, 10,new OrderDetail(1, 20, 200, "COD", "Available")))));
		
		assertEquals(1,((List<Event>) service.viewEvent()).size());
	}
	
	@Test
	public void insertEventTest()
	{
		Event event  = new Event(2, "Worldcup", "Worldcup Cricket", "12-1-2020", true, "Venue",100,new Category(1, "Platinum", 200, false, 10,new OrderDetail(1, 20, 200, "Gpay", "Available" )));
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
		Event event  = new Event(2, "Concert", "Singing concert", "12-1-2020", true, "Venue",100,new Category(1, "Platinum", 200, false, 10,new OrderDetail(1, 20, 200, "Gpay", "Available" )));
		when(eventDao.save(event)).thenReturn(event);
		assertEquals(event, service.Update(event));
	}
	
	
}
