package com.edu.CollegeManagementApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.CollegeManagementApp.entity.Announcement;
import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;
import com.edu.CollegeManagementApp.entity.Teacher;
import com.edu.CollegeManagementApp.entity.User;
import com.edu.CollegeManagementApp.service.AnnouncementService;
import com.edu.CollegeManagementApp.service.CourseService;
import com.edu.CollegeManagementApp.service.StudentService;
import com.edu.CollegeManagementApp.service.TeacherService;
import com.edu.CollegeManagementApp.service.UserService;

@Controller
public class TeacherController {
	
	TeacherService teacherService;
	AnnouncementService annService;
	CourseService courseService;
	UserService userService;
	StudentService stuService;
	
	
	public TeacherController(TeacherService teacherService, AnnouncementService annService, CourseService courseService,
			UserService userService, StudentService stuService) {
		super();
		this.teacherService = teacherService;
		this.annService = annService;
		this.courseService = courseService;
		this.userService = userService;
		this.stuService = stuService;
	}



	@GetMapping("/teacher/portal")
	public String teacherPortal() {
		return "teacher-profile";
		
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
	
	@GetMapping("/addTeacher")
	public String addTeacher(Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "teacher-registration";
		
	}

	@PostMapping("/teacherRegistration")
	public String teacherRegistration( @Valid Teacher teacher, BindingResult result, Model model) {
		if (result.hasErrors()) {
		    return "teacher-registration";
		  }else {
	    teacherService.saveTeacher(teacher);
	    User user = new User(teacher.getEmail(), teacher.getPassword(),"ROLE_TEACHER", true);
	    userService.saveUser(user);
		
		model.addAttribute("successMessage", "Details are saved successfully");
		
		}
	    return "teacher-profile";
	    
	}
	
	@GetMapping("/teacher/addAnnouncement")
	public String addAnnouncement(Model model) {
		Announcement ann = new Announcement();
		model.addAttribute("ann", ann);
		return "announcement-form";
	}
	
	@PostMapping("/teacher/saveAnnouncement")
	public String saveAnnouncement(Announcement ann, Model model) {
		annService.saveAnnouncement(ann);
		model.addAttribute("message", "New details are added successfully");
		return "list-announce";
		
	}
	
	@DeleteMapping("/teacher/deleteAnnounce/{id}")
	public String deleteAnnouncement( @PathVariable(value= "") long id, Model model) {
		System.out.println(id);

		annService.deleteAnnouncement(id);
		
		model.addAttribute("message", "Details are deleted successfully");
		allAnn(model);
		return "list-announce";
		
	}
	
	@GetMapping("/teacher/allAnnouncement")
	public String allAnn(Model model) {
		List<Announcement> anns = annService.getAllAnnounce();
		model.addAttribute("anns", anns);
		return "list-announce";
		
	}
	
	@GetMapping("/teacher/courseList")
	public String courseList(Model model) {
		String userEmail = currentUser();
		long id = teacherService.getIdByEmail(userEmail);
		List<Course> courses= courseService.getCoursesByTeacherrId(id);
		model.addAttribute("teacherCourses", courses);
		
		return "teacher-course";
		
	}
	
	@GetMapping("/teacher/listStudent/{id}")
	
	public String listStudentCourse(@PathVariable(value="") long id, Model model) {
		List<Student> students = stuService.courseToStudent(id);
		model.addAttribute("students", students);
		return "course-student";
		
	}

}
