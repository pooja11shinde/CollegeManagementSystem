package com.edu.CollegeManagementApp.service;

import javax.validation.Valid;

import com.edu.CollegeManagementApp.entity.Teacher;

public interface TeacherService {

	void saveTeacher(Teacher teacher);

	long getIdByEmail(String userEmail);

}
