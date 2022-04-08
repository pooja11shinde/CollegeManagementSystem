package com.edu.CollegeManagement.service;

import java.util.List;

import com.edu.CollegeManagement.Entity.Teacher;

public interface TeacherService {
	
	Teacher saveTeacher(Teacher teacher);
	List<Teacher> getAllTeacher();
	Teacher getTeacherById(long id);
	Teacher updateTeacher(Teacher teacher, long id);
	void deleteTeacher(long id);
	List<Teacher> getTeacherByFirstName(String firstName);//john
	List<Teacher> getTeacherByLastName(String lastName);
	List<Teacher> getTeachersById(List<Long> id);
	List<Teacher> getTeacherByFirstNameOrLastName(String firstName, String lastName);
	List<Teacher> getTeacherByFirstNameAndLastName(String firstName, String lastName);
	Teacher getTeacherFullNameById(long id);
	List<Teacher> getTeacherInDescOrder();
	List<Teacher> getTeacherByDepartmentGroup();
	List<Teacher> getTeachersByFirstName(String firstName);
}
	

