package com.edu.CollegeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.CollegeManagement.Entity.Student;
import com.edu.CollegeManagement.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

	List<Student> findByFirstName(String firstName);


	Teacher findTeacherFullNameById(long id);

	List<Teacher> findTeacherInDescOrder();


	List<Teacher> findByFirstNameOrLastName(String firstName, String lastName);

	List<Teacher> findByLastName(String lastName);

	List<Teacher> findTeachersByFirstName(String firstName);

	List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);





 

}
