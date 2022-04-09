package com.edu.CollegeManagementApp.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.Student;
import com.edu.CollegeManagementApp.entity.Teacher;
import com.edu.CollegeManagementApp.entity.User;
import com.edu.CollegeManagementApp.repository.StudentRepository;
import com.edu.CollegeManagementApp.repository.TeacherRepository;
import com.edu.CollegeManagementApp.repository.UserRepository;
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found "+ email));
		return user.map(MyUserDetails::new).get();
		//return new MyUserDetails(user);
	}

}
