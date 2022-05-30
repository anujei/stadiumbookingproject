package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDetailDao;
import com.example.demo.entity.OrderDetail;

@Service
public class OrderDetailService {

	@Autowired
	OrderDetailDao orderDetailDao;
	

	public OrderDetail create(OrderDetail orderDetail)
	{
		return orderDetailDao.save(orderDetail); 
	}
	
	
	public Iterable<OrderDetail> select() {
        return orderDetailDao.findAll();
    }
	

	public void delete(int OrderId) {
		orderDetailDao.deleteById(OrderId);
		}
	
	public void Update(OrderDetail orderDetail)
	{
		orderDetailDao.save(orderDetail); 
	}
}