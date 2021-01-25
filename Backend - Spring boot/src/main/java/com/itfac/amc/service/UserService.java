package com.itfac.amc.service;

import com.itfac.amc.dto.UpdateUserDto;
import com.itfac.amc.dto.UserDto;
import com.itfac.amc.entity.User;

public interface UserService {

	UserDto getUserProfile(String id);

	UpdateUserDto getUserDetails(String idname);

	String addUser(User user);

	String deleteUser(String userid);

	User updateUser(String idname, User user);

}
