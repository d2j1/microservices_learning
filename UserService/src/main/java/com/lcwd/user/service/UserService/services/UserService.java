package com.lcwd.user.service.UserService.services;

import java.util.List;
import java.util.Optional;

import com.lcwd.user.service.UserService.entities.User;

public interface UserService {

	
	
	User saveUser(User user);
	
	// get all users 
	List<User> getAllUser();
	
	// get Single user of the given Id
	
	User getUser(String uId);
	
	
}
