package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private int OrderId;
	
	@Column(name= "seatno")
	@NotNull
	private int SeatNo;
	
//	@Pattern(regexp = "\\d+",message="should only numberic value")
	@NotNull
	@Column(name="total")
	private float total;
	
	@NotNull
	@Column(name="paymentoption")
	private String PaymentOption;
	
	@NotNull
	@Column(name="orderstatus")
	private int OrderStatus;
	
}
