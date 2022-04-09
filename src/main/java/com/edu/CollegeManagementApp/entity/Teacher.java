package com.edu.CollegeManagementApp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@NotBlank(message="Contact Number can't be empty")
	private String contactNo;
	@Column
	private String address;
	
	
	@OneToMany(mappedBy="teacher")
	List<Course> course;

	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public Teacher(long id, @NotBlank(message = "First name can't be Empty") String firstName,
			@NotBlank(message = "Last name can't be empty") String lastName,
			@NotBlank(message = "Email can't be empty") @Email String email,
			@NotBlank(message = "Password can't be empty") String password,
			@NotBlank(message = "Contact Number can't be empty") String contactNo, String address,
			List<Course> course) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contactNo=" + contactNo + ", course=" + course + "]";
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
