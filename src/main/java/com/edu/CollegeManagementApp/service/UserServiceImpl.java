package com.edu.CollegeManagementApp.service;

import org.springframework.stereotype.Service;

import com.edu.CollegeManagementApp.entity.User;
import com.edu.CollegeManagementApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		// TODO Auto-generated method stub
		
	}
	

}
