package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "category")
public class Category {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="categoryid")
		private int Categoryid;
		@Column(name="categorytitle")
		private String CategoryTitle;
		@Column(name="price")
		private Float price;
		@Column(name="status")
		private boolean status;
		@Column(name="no_of_seat")
		private int NoOfSeat;
		
		
		@ManyToMany(targetEntity =  OrderDetail.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
	    @JoinColumn(name= "fk_categoryid",referencedColumnName = "Categoryid")
	    private Set<OrderDetail> orderdetail;
		
		
	}
