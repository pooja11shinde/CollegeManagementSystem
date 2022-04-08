package com.edu.CollegeManagement.service;

import java.util.List;

import com.edu.CollegeManagement.Entity.Student;


public interface StudentService {
		Student saveStudent(Student student);
		List<Student> getAllStudent();
		Student getStudentById(long id);
		Student updateStudent(Student student, long id);
		Student savestudent(Student student);
		List<Student> getStudentByFirstName(String firstName);
		List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName);
		List<Student> getStudentByFirstNameOrGender(String firstName, String gender);
		List<Student> getStudentByFirstNameOrLastName(String firstName, String lastName);
		List<Student> getStudentByLastName(String lastName);
		Student updateStudentPartially(Student student, long id);
		Student deleteStudent(long id);
		Student getStudentFullNameById(long id);
		List<Student> getStudentByFirstNameAndLastName(String firstNameAndlastName);
	}


