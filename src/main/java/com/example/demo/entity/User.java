package com.example.demo.entity;

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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Transactional
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

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
		java.util.Date DateOfBirth=new java.util.Date();
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
}