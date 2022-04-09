package com.edu.CollegeManagementApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private long id;
	@Column(unique=true, nullable=false)
	private  String email;
	@Column(unique=true, nullable=false)
	private String password;
	@Column(unique=true, nullable=false)
	private String role;
	@Column
	private boolean active;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public User(long id, String email, String password, String role, boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", active="
				+ active + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password, String role, boolean active) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	
	

	

}
