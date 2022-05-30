package com.example.demo.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator.GenerationContextLocator;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private int OrderId;
	@Column(name= "seatno")
	private int SeatNo;
	@Column(name="total")
	private float total;
	@Column(name="paymentoption")
	private String PaymentOption;
	@Column(name="orderstatus")
	private String OrderStatus;

}
