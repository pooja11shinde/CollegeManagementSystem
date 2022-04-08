package com.edu.CollegeManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagement.Entity.Course;
import com.edu.CollegeManagement.exception.ResourceNotFound;
import com.edu.CollegeManagement.repository.CourseRepository;
import com.edu.CollegeManagement.service.CourseService;
@Service
public class CourseServiceImpl  implements CourseService{

	private CourseRepository courseRepository;
	
	
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}


	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}


	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
		
	}


	@Override
	public Course getCourseById(long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		else {
          
			throw new ResourceNotFound("Course","Id",id);
		}
		
	}


	@Override
	public Course updateCourse(Course course, long id) {
		Course cour = new Course();
	 try {
		   cour = courseRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Course","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 cour.setCourseName(course.getCourseName());
	 cour.setCourseCity(course.getCourseCity());
	 cour.setCourseType(course.getCourseType());
	 cour.setAddress(course.getAddress());
	 courseRepository.save(cour);
	return cour;
	}


	@Override
	public Course savecourse(Course course) {
		return courseRepository.save(course);
	}


	@Override
	public List<Course> getCourseByCourseName(String courseName) {
		return courseRepository.findByCourseName(courseName);
	}


	@Override
	public List<Course> getCoursesById(List<Long> id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Course getCourseNameById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteCourse(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Course> getCourseByCourseTitle(String courseTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	


	

}
