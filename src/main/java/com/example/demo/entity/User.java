package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
		@Id
	    @Column(name="username")
	 	private String userName;	
		
		@Email(message = "Email should be valid")
		@Column(name="emailid")
	 	private String EmailId;
	 	
		@NotEmpty
		@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$",
		message="Password must contain 1 digit, 1 lowercase letter, 1 uppercase letter, 1 special character, white space is not allowed"
				+ "and it should be between 8 to 20 characters")
	 	@Column(name="userPassword")
	 	private String userPassword;
	 	
		@NotEmpty
		@Pattern(regexp="\"[a-zA-Z]\"",message="invalid Name")
	 	@Column(name="name")
	 	private String Name;
		
		@NotEmpty
		@Pattern(regexp="(^$|[0-9]{10})", message="invalid mobile number")
		@Size(min=10,max=12,message="invalid mobile number")
		@Column(name="mobilenp")
	 	private String MobileNo;
		
		@NotEmpty
		@Pattern(regexp="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$",
		message="invalid Date of birth format it should be dd/mm/yyyy format")
		@Column(name="dob")
		private String DateOfBirth;
		
		@Size(min = 10, max = 200, message= "About Me must be between 10 and 200 characters")
		@Column(name="address")
	 	private String Address;
		
		@NotEmpty
		@Max(value=8,message="invalid pincode")
		@Pattern(regexp="(^$|[0-9]{10})", message="invalid Pincode")
		@Column(name="pincode")
	 	private int PinCode;
		
		@NotEmpty
		@Pattern(regexp="\"[a-zA-Z]\"",message="invalid state name")
		@Column(name="State")
	 	private String State;
		
		@NotEmpty
		@Pattern(regexp="\"[a-zA-Z]\"",message="invalid City name")
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