package com.edu.CollegeManagement.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="courseTbl")

public class Course {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="Course_name")
	private String courseName;
	@Column(name="Course_type")
	private String courseType;
	@Column(name="Course_city")
	private String courseCity;
	@Column(name="Address")
	private String address;
	
	//@OneToMany(mappedBy="course" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	// List<Student> student;

	
	
	@OneToMany(mappedBy="course")
	List<Student> student;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	Teacher teacher;

	public Object getCourseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCourseName(Object courseName2) {
		// TODO Auto-generated method stub
		
	}
	
}
