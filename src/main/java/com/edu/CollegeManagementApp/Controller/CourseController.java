package com.edu.CollegeManagementApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.service.CourseService;

@Controller
public class CourseController {
	
	CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
@GetMapping("/")
	
	String index() {
		return "index";
	}


@GetMapping("/contact")

String contact() {
	return "contact-us";
}


@GetMapping("/admin/courseRegistration")
public String courseRegistrationForm(Model model) {
	Course course = new Course();
	model.addAttribute("course", course);
    return "add-course";
}

@PostMapping("/admin/saveCourse")
public String saveEmployee( @Valid Course course, BindingResult result, Model model) {
	if (result.hasErrors()) {
	    return "add-course";
	  }else {
    courseService.saveCourse(course);
	model.addAttribute("successMessage", "Details are saved successfully");
	allCourse(model);
	}
    return "redirect:/login";
    
}

@GetMapping("/allCourses")
public String allCourse(Model model) {
	List<Course> courses = courseService.getAllCourse();
	model.addAttribute("courses", courses);
	return "list-course";
	
}





}
