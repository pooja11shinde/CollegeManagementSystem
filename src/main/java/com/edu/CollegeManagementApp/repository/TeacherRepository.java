package com.edu.CollegeManagementApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.CollegeManagementApp.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	Teacher findByEmail(String email);

	
	@Query("select t.id from Teacher t where t.email= :email")
	long findIdByEmail(@Param("email")String userEmail);

}
