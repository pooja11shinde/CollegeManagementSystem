package com.edu.CollegeManagementApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.CollegeManagementApp.entity.Announcement;
import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;
import com.edu.CollegeManagementApp.entity.Teacher;
import com.edu.CollegeManagementApp.entity.User;
import com.edu.CollegeManagementApp.service.AnnouncementService;
import com.edu.CollegeManagementApp.service.CourseService;
import com.edu.CollegeManagementApp.service.StudentService;
import com.edu.CollegeManagementApp.service.UserService;

@Controller
public class StudentController {
	
	StudentService studentService;
	UserService userService;
	AnnouncementService annService;
	CourseService courseService;
	

	public StudentController(StudentService studentService, UserService userService, AnnouncementService annService) {
		super();
		this.studentService = studentService;
		this.userService = userService;
		this.annService = annService;
	}
	
	public String currentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String userEmail;
		if (principal instanceof UserDetails) {
		    userEmail = ((UserDetails)principal).getUsername();
		} else {
		     userEmail = null;
		}
       return userEmail;
	}


	@GetMapping("/student/portal")
	public String studentPortal() {
		return "student-portal";
	}
	
	@GetMapping("/addStudent")
	public String addTeacher(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-registration";
		
	}

	/*@GetMapping("/registrationForm")
	public String registrationForm(Model model) {
		model.addAttribute("object", new Object());
		return "registration";
	}*/
	
	@PostMapping("/studentRegistration")
	public String studentRegistration( @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
		    return "student-registration";
		  }else {
			  
	    studentService.saveStudent(student);
	    User user = new User(student.getEmail(), student.getPassword(),"ROLE_STUDENT", true);
	    userService.saveUser(user);
		model.addAttribute("successMessage", "Details are saved successfully");
		
		}
	    return "student-portal";
	    
	}
	
	@GetMapping("/allStudent")
	public String allStudent(Model model) {
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		return "list-course";
		
	}
	
	@GetMapping("/student/listAnnouncement")
	public String allAnn(Model model) {
		List<Announcement> anns = annService.getAllAnnounce();
		model.addAttribute("anns", anns);
		return "student-announcement";
		
	}
	
	@GetMapping("/student/courseList")
	public String studentCourse() {
		String userEmail = currentUser();
		long id = studentService.getIdByEmail(userEmail);
		long courseId = studentService.getCourseId(id);
		System.out.println(courseId);
		Course course = courseService.getCourseForStu(courseId);
		
		return null;
		
	}

}
