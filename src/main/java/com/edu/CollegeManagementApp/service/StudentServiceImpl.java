package com.edu.CollegeManagementApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.Course;
import com.edu.CollegeManagementApp.entity.Student;
import com.edu.CollegeManagementApp.entity.Teacher;
import com.edu.CollegeManagementApp.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	StudentRepository stuRepository;
	
	public StudentServiceImpl(StudentRepository stuRepository) {
		super();
		this.stuRepository = stuRepository;
	}

	@Override
	public void saveStudent(Student student) {
		stuRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> students = stuRepository.findAll();
		return null;
	}

	@Override
	public List<Student> courseToStudent(long id) {
		return stuRepository.findByCourseId(id);
		
		//return null;
	}

	@Override
	public long getIdByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCourseId(long id) {
		return stuRepository.findCourseId(id);
	}


	
      
}
