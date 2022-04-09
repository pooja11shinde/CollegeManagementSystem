package com.edu.CollegeManagementApp.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;

public interface CourseService {

	void saveCourse(@Valid Course course);

	List<Course> getAllCourse();

	List<Course> getCoursesByTeacherrId(long id);

	Course getCourseForStu(long courseId);

	
}
