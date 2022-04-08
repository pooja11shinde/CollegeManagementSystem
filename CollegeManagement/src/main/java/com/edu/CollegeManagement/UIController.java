package com.edu.CollegeManagement;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.CollegeManagement.Entity.Course;
import com.edu.CollegeManagement.Entity.Student;
import com.edu.CollegeManagement.Entity.Teacher;
import com.edu.CollegeManagement.service.CourseService;
import com.edu.CollegeManagement.service.StudentService;
import com.edu.CollegeManagement.service.TeacherService;

@Controller
public class UIController {
	
	private StudentService studentService;
	private TeacherService teacherService;
	private CourseService courseService;
	
	
@Autowired	
public UIController(StudentService studentService, TeacherService teacherService,
			CourseService courseService) {
		super();
		this.studentService = studentService;
		this.teacherService = teacherService;
		this.courseService = courseService;
	}

//@GetMapping("/")
	
	//String index() {
	//	return "index";/// index.html
	//}

// Student 
@GetMapping("/registration")
public String studRegistrationForm(Model model) {
	Student student = new Student();
	model.addAttribute("student", student);
    return "add-student";
}

@PostMapping("/saveStudent")
public String saveStudent(@Valid  Student student, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "redirect:/";
	else {
    studentService.saveStudent(student);
	//@SuppressWarnings("unused")
	List<Student> students =  studentService.getAllStudent();
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "redirect:/getStudents";
    
}

@GetMapping("/getStudents")
public String getAllStudent(Model model) {
	
	List<Student> students =  studentService.getAllStudent();
	
	model.addAttribute("students", students);
	
    return "list-student";}



// Department 

@GetMapping("/courseRegister")
public String courseRegistrationForm(Model model) {
	Course course = new Course();
	model.addAttribute("course", course);
    return "add-course";
}

@PostMapping("/savecourse")
public String addcourse(@Valid  Course course, Errors errors, Model model) {
	if(null != errors && errors.getErrorCount() > 0)
		return "add-course";
	else {
    courseService.saveCourse(course);
    model.addAttribute("successMessage", "Details are saved successfully");
	}
    return "list-course";
}
    @GetMapping("/getcourses")
    public String getAllCourse(Model model) {
    	
    	List<Course> courses =  courseService.getAllCourse();
    	
    	model.addAttribute("courses", courses);
    	
        return "list-course";
        }

 // Teacher 
    @GetMapping("/TeacherRegistration")
    public String teachRegistrationForm(Model model) {
    	Teacher teacher = new Teacher();
    	model.addAttribute("teacher", teacher);
        return "add-teacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@Valid  Teacher teacher, Errors errors, Model model) {
    	if(null != errors && errors.getErrorCount() > 0)
    		return "redirect:/";
    	else {
        teacherService.saveTeacher(teacher);
    	//@SuppressWarnings("unused")
		List<Teacher> teachers =  teacherService.getAllTeacher();
        model.addAttribute("successMessage", "Details are saved successfully");
    	}
        return "redirect:/getTeachers";
        
    }

    @GetMapping("/getTeachers")
    public String getAllTeacher(Model model) {
    	
    	List<Teacher> teachers =  teacherService.getAllTeacher();
    	
    	model.addAttribute("teachers", teachers);
    	
        return "list-teacher";}




}


