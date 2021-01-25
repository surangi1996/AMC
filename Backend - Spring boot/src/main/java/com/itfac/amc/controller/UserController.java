package com.itfac.amc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.itfac.amc.dto.UpdateUserDto;
import com.itfac.amc.dto.UserDto;
import com.itfac.amc.entity.User;
import com.itfac.amc.repository.UserRepository;
import com.itfac.amc.service.UserService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("user/")
public class UserController {
	
	@Autowired
	UserService userService;
	UserRepository UserRepository;
	
	 
	
	@GetMapping("getProfile/{idname}")
	UserDto getUserProfile(@PathVariable("idname") String id){
		
		UserDto userProfile = userService.getUserProfile(id);
		return userProfile;
		
	}
	
	@GetMapping("getUser/{idname}")
	UpdateUserDto updateUserDetails(@PathVariable("idname") String id){
		
		UpdateUserDto userDetails = userService.getUserDetails(id);
		return userDetails;
		
	}
	

	
	@PutMapping("/updateUser/{idname}")
	 public User updateUser(@RequestBody User user, @PathVariable String idname) {
		return userService.updateUser( idname, user);	
	}

	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	                                                                                                                                                                                                                                                     
	@DeleteMapping("/delete/{userid}")
	public String deleteUser(@PathVariable String userid) {
		return userService.deleteUser(userid);
	}

}
