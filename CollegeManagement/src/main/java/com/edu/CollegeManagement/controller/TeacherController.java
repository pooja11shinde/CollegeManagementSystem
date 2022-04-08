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

import com.edu.CollegeManagement.Entity.Teacher;
import com.edu.CollegeManagement.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")// url

public class TeacherController {

	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

@PostMapping
// saveTeacher(Teacher obj)
public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
	return new ResponseEntity<Teacher>(teacherService.saveTeacher(teacher),HttpStatus.CREATED);
}


@GetMapping
public List<Teacher> getAllTeacher()
{
	return teacherService.getAllTeacher();
}

@GetMapping("{id}")//4
public ResponseEntity<Teacher>getTeacherById(@PathVariable("id") long id) {
	return new ResponseEntity<Teacher>(teacherService.getTeacherById(id), HttpStatus.OK);
}

@GetMapping("/teacherByFirstName/{firstName}")//john
public List<Teacher> getTeacherByFirstName(@PathVariable("firstName")String firstName){
	return teacherService.getTeacherByFirstName(firstName);//john
}

@GetMapping("/teacherByLastName/{lastName}")//doe
public List<Teacher> getTeacherByLastName(@PathVariable("lastName") String lastName){
	return teacherService.getTeacherByLastName(lastName);//deo
	
}

	@GetMapping("/teacherByFirstNameAndLastName")
public List<Teacher> getTeacherByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
{
	return teacherService.getTeacherByFirstNameAndLastName(firstName, lastName);
	
}


@GetMapping("/teacherByFirstNameOrLastName")
public List<Teacher> getTeacherByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
{
	return teacherService.getTeacherByFirstNameOrLastName(firstName, lastName);
	
}

@GetMapping("/teacherByIds")
public List<Teacher> getTeachersByIds(@RequestParam(value="id") List<Long> id){
	return  teacherService.getTeachersById(id);
}

/*@GetMapping("/teacherByCourse/{id}")
public List<Teacher> getteacherByCourse(@PathVariable("id") Long id){
	return teacherService.getTeacherByCourse(id);
	
}*/


@GetMapping("/teacherFullNameById/{id}")
public Teacher getTeacherFullNameById( @PathVariable("id") long id){
	return teacherService.getTeacherFullNameById(id);
}

	@PutMapping("{id}")
public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") long id, @RequestBody Teacher teacher){
	
	return new ResponseEntity<Teacher>(teacherService.updateTeacher(teacher, id),HttpStatus.OK);
	
}
	
@GetMapping("/teacherInDescOrder")
public List<Teacher> getTeacherInDescOrder(){
	return teacherService.getTeacherInDescOrder();
}

// CRUD
@DeleteMapping("{id}")
public ResponseEntity<String> deleteTeacher(@PathVariable("id") long id){
	teacherService.deleteTeacher(id);
	return new ResponseEntity<String>("Teacher record deleted ",HttpStatus.OK);
	
}




}
	