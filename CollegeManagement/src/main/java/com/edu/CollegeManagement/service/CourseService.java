package com.edu.CollegeManagement.service;

import java.util.List;

import com.edu.CollegeManagement.Entity.Course;

public interface CourseService {
	Course saveCourse(Course course);
	List<Course> getAllCourse();
	Course getCourseById(long id);
	Course updateCourse(Course course, long id);
	Course savecourse(Course course);
	//List<Course> getCourseByCourseName(String courseName);
	List<Course> getCoursesById(List<Long> id);
	Course getCourseNameById(long id);
	void deleteCourse(long id);
	List<Course> getCourseByCourseTitle(String courseTitle);
	List<Course> getCourseByCourseName(String courseName);
	
}
