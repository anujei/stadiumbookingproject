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

import com.example.demo.dao.OrderDetailDao;
import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderDetailService;

@SpringBootTest
public class OrderDetailsTests {

	@Autowired
	private OrderDetailService service;
	@MockBean
	private OrderDetailDao orderDetailDao;
	
	@Test
	public void findAllOrderDetailTest()
	{
		when(orderDetailDao.findAll()).thenReturn(List.of(new OrderDetail(1, 100, 200f, "COD", 0)));
		assertEquals(1,((List<OrderDetail>) service.select()).size());
	}
	
	@Test
	public void insertOrderDetailTest()
	{
		OrderDetail orderDetail  = new OrderDetail(1, 100, 200f, "COD", 0);
		when(orderDetailDao.save(orderDetail)).thenReturn(orderDetail);
		assertEquals(orderDetail, service.create(orderDetail));
	}
	@Test
	public void DeleteOrderDetailTest() {
		service.delete(1);
		verify(orderDetailDao, times(1)).deleteById(1);
		
	}
	@Test
	public void UpdateOrderDetailTest()
	{
		OrderDetail orderDetail  = new OrderDetail(1, 100, 200f, "COD", 0);
		when(orderDetailDao.save(orderDetail)).thenReturn(orderDetail);
		assertEquals(orderDetail, service.Update(orderDetail));
	}
	
}