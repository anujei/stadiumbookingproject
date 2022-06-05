package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Transactional
@Getter
@Setter

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "user")
public class User {

	 	


		public User(String userName, String emailId, String userPassword, String name, int mobileNo, String dateOfBirth,
			String address, int pinCode, String state, String city, Set<Role> role, Set<OrderDetail> orderdetails) {
		super();
		this.userName = userName;
		EmailId = emailId;
		this.userPassword = userPassword;
		Name = name;
		MobileNo = mobileNo;
		DateOfBirth = dateOfBirth;
		Address = address;
		PinCode = pinCode;
		State = state;
		City = city;
		role = role;
		orderdetails = orderdetails;
	}


		public User() {
		super();
		// TODO Auto-generated constructor stub
	}


//		public User(String userName2, String emailId2, String userPassword2, String name2, int mobileNo2, String string,
//				String address2, int pinCode2, String state2, String city2, Role role2, OrderDetail orderDetail) {
//			// TODO Auto-generated constructor stub
//		}


		

		public User(String userName2, String emailId2, String userPassword2, String name2, int mobileNo2,
				String dateOfBirth2, String address2, int pinCode2, String state2, String city2, Role role2,
				Object orderdetails2) {
			// TODO Auto-generated constructor stub
		}


		@Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="username")
	 	private String userName;	
	 	
	 	@Column(name="emailid")
	 	private String EmailId;
	 	
	 	@Column(name="userPassword")
	 	private String userPassword;
	 	
	 	@Column(name="name")
	 	private String Name;
		@Column(name="mobilenp")
		
	 	private int MobileNo;
		@Column(name="dob")
		String DateOfBirth;
		@Column(name="address")
	 	private String Address;
		@Column(name="pincode")
	 	private int PinCode;
		@Column(name="State")
	 	private String State;
	 	@Column(name="city")
	 	private String City;
	 	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "USER_ROLE",
	            joinColumns = {
	                    @JoinColumn(name = "USER_ID")
	            },
	            inverseJoinColumns = {
	                    @JoinColumn(name = "ROLE_ID")
	            }
	    )
	 	private Set<Role> role;
	 	
	 	
	 	@OneToMany(targetEntity =  OrderDetail.class ,cascade = CascadeType. ALL, fetch=FetchType.LAZY)
	    @JoinColumn(name= "fk_userid",referencedColumnName = "username")
	    private Set<OrderDetail> orderdetails;
//	 	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//	 	Set<User> user;


		
	 	
	 	
}