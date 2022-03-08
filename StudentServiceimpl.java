package com.edu.CollegeManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagement.Entity.Student;
import com.edu.CollegeManagement.exception.ResourceNotFound;
import com.edu.CollegeManagement.repository.StudentRepository;
import com.edu.CollegeManagement.service.StudentService;
@Service
public class StudentServiceimpl implements StudentService{

	private StudentRepository studentRepository;
	
	
	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
		
	}


	@Override
	public Student getStudentById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		else {
          
			throw new ResourceNotFound("Student","Id",id);
		}
		
	}


	@Override
	public Student updateStudent(Student student, long id) {
		Student stu = new Student();
	 try {
		   stu = studentRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Student","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 stu.setFirstName(student.getFirstName());
	 stu.setLastName(student.getLastName());
	 stu.setEmail(student.getEmail());
	 stu.setAddress(student.getAddress());
	 stu.setContactNo(student.getContactNo());
	 stu.setDob(student.getDob());
	 studentRepository.save(stu);
	return stu;
	}


	@Override
	public Student savestudent(Student student) {
		return studentRepository.save(student);
	}


	@Override
	public List<Student> getStudentByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}


	@Override
	public List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByFirstNameOrGender(String firstName, String gender) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByFirstNameOrLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student updateStudentPartially(Student student, long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student deleteStudent(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Student getStudentFullNameById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


		
}