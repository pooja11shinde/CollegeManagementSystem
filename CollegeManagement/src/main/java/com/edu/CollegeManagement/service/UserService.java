package com.edu.CollegeManagement.service;

import java.util.List;
import java.util.Optional;

import com.edu.CollegeManagement.Entity.User;

public interface UserService {
	   public Optional<User> findUserByUserName(String userName);

	public User updateUser(User user, long id);

	public User getUserById(long id);

	public List<User> getAllUser();

	public User saveUser(User user);


}
