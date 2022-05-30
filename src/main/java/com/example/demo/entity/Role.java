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
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "roleid")
//    private int roleid;
	@Column(name = "roleName")
	private String roleName;
	@Column(name = "roleDescription")
	private String roleDescription;
//    public String getRoleid() {
//		return roleid;
//	}
//
//	public void setRoleid(String roleid) {
//		this.roleid = roleid;
//	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}