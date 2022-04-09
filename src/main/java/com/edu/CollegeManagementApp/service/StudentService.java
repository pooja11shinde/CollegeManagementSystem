package com.edu.CollegeManagementApp.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;
import com.edu.CollegeManagementApp.entity.Teacher;

public interface StudentService {

	void saveStudent( Student student);

	List<Student> getAllStudent();

	List<Student> courseToStudent(long id);

	long getIdByEmail(String userEmail);

	long getCourseId(long id);

	}
