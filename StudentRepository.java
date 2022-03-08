package com.edu.CollegeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.CollegeManagement.Entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String firstName);

	Student findStudentFullNameById(long id);

	Student deleteStudentNameById(long id);


	
}
