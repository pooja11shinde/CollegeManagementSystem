package com.edu.CollegeManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.CollegeManagement.Entity.Course;
import com.edu.CollegeManagement.service.CourseService;

@RestController
@RequestMapping("/api/Course")

public class CourseController {
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

@PostMapping
// saveCourse(Course obj)
public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
	return new ResponseEntity<Course>(courseService.saveCourse(course),HttpStatus.CREATED);
}


@GetMapping
public List<Course> getAllCourse()
{
	return courseService.getAllCourse();
}

@GetMapping("{id}")//4
public ResponseEntity<Course>getCourseById(@PathVariable("id") long id) {
	return new ResponseEntity<Course>(courseService.getCourseById(id), HttpStatus.OK);
}

@GetMapping("/courseByCourseTitle/{courseTitle}")//john
public List<Course> getCourseByCourseName(@PathVariable("courseTitle")String courseTitle){
	return courseService.getCourseByCourseTitle(courseTitle);//john
}


	
@GetMapping("/courseByIds")
public List<Course> getCoursesByIds(@RequestParam(value="id") List<Long> id){
	return  courseService.getCoursesById(id);
}


@GetMapping("/courseNameById/{id}")
public Course getCourseNameById( @PathVariable("id") long id){
	return courseService.getCourseNameById(id);
}

	@PutMapping("{id}")
public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course){
	
	return new ResponseEntity<Course>(courseService.updateCourse(course, id),HttpStatus.OK);
	
}
	

// CRUD
@DeleteMapping("{id}")
public ResponseEntity<String> deleteCourse(@PathVariable("id") long id){
	courseService.deleteCourse(id);
	return new ResponseEntity<String>("Teacher record deleted ",HttpStatus.OK);
	
}
}
	