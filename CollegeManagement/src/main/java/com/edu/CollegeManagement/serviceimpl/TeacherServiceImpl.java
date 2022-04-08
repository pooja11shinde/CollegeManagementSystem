package com.edu.CollegeManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagement.Entity.Teacher;
import com.edu.CollegeManagement.exception.ResourceNotFound;
import com.edu.CollegeManagement.repository.TeacherRepository;
import com.edu.CollegeManagement.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	private TeacherRepository teacherRepository;
	
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}


	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}


	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
		
	}
// 4 - >Teacher teacher = {"Akanksha", "pandey"}
// 12 - >Teacher teacher =  null
	@Override
	public Teacher getTeacherById(long id) {//4
		Optional<Teacher> teacher = teacherRepository.findById(id);//4
		if(teacher.isPresent()) {
			return teacher.get();
		}
		else {
          
			throw new ResourceNotFound("Teacher","Id",id);
		}
		
	}


	@Override
	public Teacher updateTeacher(Teacher teacher, long id) {
		Teacher tech = new Teacher();
	 try {
		 //orElseThrow();
		   tech = teacherRepository.findById(id).orElseThrow(//4
				 ()-> 		 new ResourceNotFound("Teacher","Id",id));
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 tech.setFirstName(teacher.getFirstName());
	 tech.setLastName(teacher.getLastName());
	 tech.setEmail(teacher.getEmail());
	 tech.setAddress(teacher.getAddress());
	 tech.setContactNo(teacher.getContactNo());
	 tech.setDob(teacher.getDob());
	 teacherRepository.save(tech);
	return tech;
	}



	@Override
	public void deleteTeacher(long id) {//13
		teacherRepository.findById(id).orElseThrow(
				()->new ResourceNotFound("Teacher","Id",id));
		
		teacherRepository.deleteById(id);//13
		
	}
	
	@Override
	public List<Teacher> getTeachersByFirstName(String firstName) {//john
				return teacherRepository.findTeachersByFirstName(firstName);
	}


	@Override
	public List<Teacher> getTeacherByLastName(String lastName) {// deo
		return teacherRepository.findByLastName(lastName);
		
	}


	/*@Override
	public List<Teacher> getTeachersByIds(List<Long> idList) {
		return teacherRepository.findTeachersByIds(idList);
	}*/


	
	@Override
	public List<Teacher> getTeacherByFirstNameOrLastName(String firstName, String lastName) {
		return teacherRepository.findByFirstNameOrLastName(firstName, lastName);
	}

// select * from employeeTbl where first_name="john" ANd last_name="doe"
	@Override
	public List<Teacher> getTeacherByFirstNameAndLastName(String firstName, String lastName) {
		return teacherRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	@Override
	public List<Teacher> getTeachersById(List<Long> idList) {
		
		return null;//teacherRepository.findTeachersById(idList);
	}


	@Override
	public List<Teacher> getTeacherByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Teacher getTeacherFullNameById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Teacher> getTeacherInDescOrder() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Teacher> getTeacherByDepartmentGroup() {
		// TODO Auto-generated method stub
		return null;
	}




	/*@Override
	public List<Teacher> getTeacherByCourse(long id) {
		return teacherRepository.findByCourseId(id);
	}*/


		}


	


		

