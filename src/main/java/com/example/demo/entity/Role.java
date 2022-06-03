package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@NotEmpty
	@Max(value=10,message="role string is too long")
	private String roleName;
	
	@Column(name = "roleDescription")
	@NotEmpty
	private String roleDescription;

}