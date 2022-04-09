package com.edu.CollegeManagementApp.service;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.Teacher;
import com.edu.CollegeManagementApp.repository.TeacherRepository;

@Service
public class TeacherServiceImpl  implements TeacherService{

	TeacherRepository teacherRepository;
	
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	@Override
	public long getIdByEmail(String userEmail) {
		return teacherRepository.findIdByEmail(userEmail);
		
		
	}

}
