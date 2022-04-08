package com.edu.CollegeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.CollegeManagement.Entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String firstName);

	//List<Student> findByFirstNameAndLastName(Object firstNameAndlastName);

	//List<Student> findByFirstNameOrLastName(Object firstNameOrLastName);

	List<Student> findByLastName(String lastName);



	/*List<Student> findByFirstNameAndLastName(String firstNameAndlastName);

	List<Student> findByLastName(String lastName);

	
	Student findStudentFullNameById(long id);

	Student deleteStudentNameById(long id);

	List<Student> findByFirstNameAndLastName(Object firstNameAndlastName);

	List<Student> findByFirstNameOrLastName(Object firstNameOrLastName);



	Student deleteById();*/


	
}
