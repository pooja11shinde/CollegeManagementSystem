package com.edu.CollegeManagementApp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	CourseRepository courseRepo;
	
	

	public CourseServiceImpl(CourseRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}


	@Override
	public List<Course> getAllCourse() {
		List<Course> courses = courseRepo.findAll();
		return courses;
	}



	@Override
	public void saveCourse(@Valid Course course) {		
		courseRepo.save(course);

		
	}


	@Override
	public List<Course> getCoursesByTeacherrId(long id) {
		return  courseRepo.findCourseByTeacherId(id);
		
		//return null;
	}


	@Override
	public Course getCourseForStu(long courseId) {
		
		return courseRepo.findCourseForStu(courseId);
	}

}
