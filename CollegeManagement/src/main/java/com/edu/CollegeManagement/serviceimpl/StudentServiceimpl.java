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
	private Object FirstNameOrLastName;
	private Object firstNameAndlastName;
	
	
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




	

	

	/*@Override
	public List<Student> getStudentByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(FirstNameOrLastName);
	}
*/

	@Override
	public List<Student> getStudentByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}


	@Override
	public Student updateStudentPartially(Student student, long id) {
		return null;
	}


	/*@Override
	public Student deleteStudent(long id) {
		return studentRepository.deleteById();
	}*/


	@Override
	public Student getStudentFullNameById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByFirstNameOrGender(String firstName, String gender) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstNameAndlastName);
	}

*/
	

	
	@Override
	public Student deleteStudent(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByFirstNameAndLastName(String firstNameAndlastName) {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getFirstNameOrLastName() {
		return FirstNameOrLastName;
	}


	public void setFirstNameOrLastName(Object firstNameOrLastName) {
		FirstNameOrLastName = firstNameOrLastName;
	}


	public Object getFirstNameAndlastName() {
		return firstNameAndlastName;
	}


	public void setFirstNameAndlastName(Object firstNameAndlastName) {
		this.firstNameAndlastName = firstNameAndlastName;
	}


	@Override
	public List<Student> getStudentByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Student> getStudentByFirstNameOrLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}



	

		
