package com.edu.CollegeManagementApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.CollegeManagementApp.entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{

	@Query("select c from Course c where c.teacher.id = :id ")
	
	List<Course> findCourseByTeacherId(@Param("id")long id);

	@Query("select c from Course c where c.id = :id")
	Course findCourseForStu(@Param("id")long courseId);

}
