package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Role")
@Getter
@Setter
@Data
@Entity
public class Role {

	@Id
	@Column(name = "roleName")
	private String roleName;
	
	@Column(name = "roleDescription")
	private String roleDescription;
	
	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public Role() {
		// TODO Auto-generated constructor stub
	}

}