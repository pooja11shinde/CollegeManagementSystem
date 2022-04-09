package com.edu.CollegeManagementApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	
	@Id
	private long id;
	@Column
	@NotBlank(message="First name can't be Empty")
	private String firstName;
	@Column
	@NotBlank(message="Last name can't be empty")
	private String lastName;
	@Column
	@NotBlank(message="Email can't be empty")
	@Email
	private String email;
	@Column
	@NotBlank(message="Password can't be empty")
	private String password;
	@Column
	private String role;
	@Column 
	private boolean active;
	@Column
	@NotBlank(message="Contact Number can't be empty")
	private String contactNo;
	@Column
	private String address;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	Course course;

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	

	

	public Student(long id,
			@NotBlank(message = "First name can't be Empty") @NotNull(message = "Please enter First name ") String firstName,
			@NotBlank(message = "Last name can't be empty") @NotNull(message = "Please enter Last name") String lastName,
			@NotBlank(message = "Email can't be empty") @NotNull(message = "Please enter Email") @Email String email,
			@NotBlank(message = "Password can't be empty") @NotNull(message = "Please enter Password") String password,
			String role, boolean active,
			@NotBlank(message = "Contact Number can't be empty") @NotNull(message = "Please enter Contact Number") String contactNo,
			String address, Course course) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.active = active;
		this.contactNo = contactNo;
		this.address = address;
		this.course = course;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", active=" + active + ", contactNo=" + contactNo
				+ ", course=" + course + "]";
	}

		
	
	

}
