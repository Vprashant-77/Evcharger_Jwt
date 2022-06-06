package com.example.jwt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	
	@Id
	private String userName;
	private String UserFirstName;
	private String UserLastName;
	private String UserPassword;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
	joinColumns= {
			@JoinColumn(name="USER_ID")
			},
	 inverseJoinColumns= {
			 
			 @JoinColumn(name="ROLE_ID")	 
	 		}
		)
	private Set<Role>role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return UserFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		UserFirstName = userFirstName;
	}

	public String getUserLastName() {
		return UserLastName;
	}

	public void setUserLastName(String userLastName) {
		UserLastName = userLastName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

}
