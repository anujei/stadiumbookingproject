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
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
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
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(int categoryid, String categoryTitle, Float price, boolean status, int noOfSeat) {
			super();
			Categoryid = categoryid;
			CategoryTitle = categoryTitle;
			this.price = price;
			this.status = status;
			NoOfSeat = noOfSeat;
		}
		public int getCategoryid() {
			return Categoryid;
		}

		public void setCategoryid(int categoryid) {
			Categoryid = categoryid;
		}

		public String getCategoryTitle() {
			return CategoryTitle;
		}

		public void setCategoryTitle(String categoryTitle) {
			CategoryTitle = categoryTitle;
		}

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public int getNoOfSeat() {
			return NoOfSeat;
		}

		public void setNoOfSeat(int noOfSeat) {
			NoOfSeat = noOfSeat;
		}

		@Override
		public String toString() {
			return "Category [Categoryid=" + Categoryid + ", CategoryTitle=" + CategoryTitle + ", price=" + price
					+ ", status=" + status + ", NoOfSeat=" + NoOfSeat + "]";
		}
	}
