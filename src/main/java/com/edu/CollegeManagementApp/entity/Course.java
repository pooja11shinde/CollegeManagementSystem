package com.edu.CollegeManagementApp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity

public class Course {
	@Id
	private long id;
	@NotEmpty
	@NotNull
	@Column(unique=true)
	private String courseTitle;
	@Column
	private double courseFee;
	@Column
	private int courseDuration;
	@Column
	private String disc;
	
	public long getId() {
		return id;
	}
	
	@OneToMany(mappedBy="course")
	List<Student> student;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	Teacher teacher;
	
	
	
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
	
	
	public Course(long id, @NotEmpty @NotNull String courseTitle, double courseFee, int courseDuration, String disc,
			List<Student> student, Teacher teacher) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
		this.disc = disc;
		this.student = student;
		this.teacher = teacher;
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + ", courseFee=" + courseFee + ", courseDuration="
				+ courseDuration + ", disc=" + disc + ", student=" + student + ", teacher=" + teacher + "]";
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
