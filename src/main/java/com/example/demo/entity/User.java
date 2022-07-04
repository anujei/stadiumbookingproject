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
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

	@Id
	private String email;
	@Column
	private String userName;
	@Column
	private String Password;
	@Column
	private String mobileNo;
	@Column
	private String Address;
	@Column
	private int pincode;
	@Column
	private String DOB;
	@Column
	private String State;
	@Column
	private String City;
	
	@ManyToMany(targetEntity =  Role.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 @JoinTable(name = "USER_ROLE",
     joinColumns = {
             @JoinColumn(name = "USER_ID")
     },
     inverseJoinColumns = {
             @JoinColumn(name = "ROLE_ID")
     }
)
	private Set<Role> role; 
}
