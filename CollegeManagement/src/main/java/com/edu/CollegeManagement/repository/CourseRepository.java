package com.edu.CollegeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.CollegeManagement.Entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{


	List<Course> findByCourseName(String courseName);

}
