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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@PostMapping("/createOrder")
	@PreAuthorize("hasRole('User')")
	public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail orderDetail)
	{
		orderDetailService.create(orderDetail); 
		return new ResponseEntity<OrderDetail>(orderDetailService.create(orderDetail),HttpStatus.CREATED);
	}
	 @GetMapping("/viewOrder")
	 @PreAuthorize("hasAnyRole('User','Admin')")
	 public Iterable<OrderDetail> viewOrder(){
	        return orderDetailService.select();
	 }
	 
	 @DeleteMapping("/deleteOrder/{OrderId}")
	 @PreAuthorize("hasRole('Admin')")
	 public void deleteEvent(@PathVariable("OrderId") int OrderId) {
		 orderDetailService.delete(OrderId);
	 }
	 
	 
	 @PostMapping("/UpdateOrder")
	 @PreAuthorize("hasRole('Admin')")
	 public OrderDetail UpdateEvent(@RequestBody OrderDetail orderDetail) {
		 orderDetailService.Update(orderDetail);
		return orderDetail;
	 }
	

}