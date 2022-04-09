package com.edu.CollegeManagementApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{

	Student findByEmail(String username);

	
	@Query("select s from Student s where s.course.id = :id")
    List<Student> findByCourseId(@Param("id")long id);


	@Query("select s.course.id from Student s where s.id = :id")
	long findCourseId(@Param("id") long id);

	

}
