package com.itfac.amc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itfac.amc.dto.UpdateUserDto;
import com.itfac.amc.dto.UserDto;
import com.itfac.amc.entity.User;
import com.itfac.amc.repository.UserRepository;
import com.itfac.amc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserProfile(String id) {
		UserDto userDetails = userRepository.findByUserId(id);
		return userDetails;
	}
	
	@Override
	public UpdateUserDto getUserDetails(String idname) {
		UpdateUserDto updateUserDetails = userRepository.getByUserId(idname);
		return updateUserDetails;
	}

	
	public String addUser(User user) {
		 User returnUser = userRepository.save(user);
		 if(returnUser != null) {
			 return "success"; 
		 }
		return "fail";
		
		
	}
	
	@Override
	public String deleteUser(String userid) {
		 userRepository.deleteById(userid);
		 return "delete complete";
				
	}

	
	@Override
	public User updateUser(String idname, User user) {
		User existingUser = userRepository.findById(user.getUserId()).orElse(null);
		if(existingUser != null) {
			
			existingUser.setUname(user.getUname());
			existingUser.setContactNo(user.getContactNo());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			
			return userRepository.save(existingUser);
			
		}
		return null;
		
//		if(existingUser != null) {
//			return userRepository.save(user);
//		}
//		return null;

	}

}
