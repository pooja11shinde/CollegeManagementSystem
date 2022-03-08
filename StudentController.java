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

import com.edu.CollegeManagement.Entity.Student;
import com.edu.CollegeManagement.service.StudentService;

@RestController
@RequestMapping("/api/student")

public class StudentController{
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student ) {
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Student> getAllStudent()
	{
		return studentService.getAllStudent();
	}
	@GetMapping("{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable("id") long id) {
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
	@GetMapping("/studentByFirstName/{firstName}")
	public List<Student>getStudentByFirstNamee(@PathVariable("firstName") String firstName) {
return studentService.getStudentByFirstName(firstName);
}
	
	
	@GetMapping("/studentByLastName/{lastName}")
	public List<Student> getStudentByLastName(@PathVariable("lastName") String lastName){
		return studentService.getStudentByLastName(lastName);
	}
	
	@GetMapping("/studentByFirstNameAndLastName")//using by JPQL
	public List<Student> getStudentByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return studentService.getStudentByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/studentByFirstNameOrLastName")
	public List<Student> getStudentByFirstNameOrLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return studentService.getStudentByFirstNameOrLastName(firstName, lastName);
	}
	/*
	@GetMapping("/StudentFullNameById")
	public ResponseEntity<Student> getStudentFullNameById(@PathVariable("id") long id){
		return new ResponseEntity<Student> (studentService.getStudentFullNameById(id), HttpStatus.OK);
		
	}
	*/
	
	
	/*
	@GetMapping("/studentOrderByFirstName")
	public List<Student> getStudentOrderByFirstNameAsc(){
		return studentService.getStudentOrderByFirstNameAsc();
	}
	*/
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateUser(@PathVariable("id") long id, @RequestBody Student student){
		return new ResponseEntity<Student> (studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String> ("Student Record Is Deleted", HttpStatus.OK);
	}
}	

	



  


	

