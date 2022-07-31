			package com.ty.hospital.hospitalappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ty.hospital.hospitalappboot.dto.Hospital;
import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private UserService userservice;
	
	@ApiOperation(value = "save the user details",produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200,message = "user saved"),
		@ApiResponse(code = 405, message = "bad request,not proper user data")
	})
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userservice.saveUser(user);
	}
	
	@ApiOperation(value = "get the user by its ID",produces = "application/Json", consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200, message = "user got"),
		@ApiResponse(code = 405, message = "bad request,invalid user id")
	})
	@GetMapping("/user")
	public User getUserById(@RequestParam int id) {
		return userservice.getUserById(id);
	}
	
	@ApiOperation(value = "get All the user", produces = "application/json", consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200, message = "got all the users"),
		@ApiResponse(code = 405, message = "bad request,please check the url you entered")
	})
	@GetMapping("/alluser")
	public List<User> getUserById() {
		return userservice.getAllUser();
	}

	@ApiOperation(value = "update the user by ID", produces = "application/Json",consumes = "application/Json")
	@ApiResponses({
		@ApiResponse(code = 200, message = "user updated Successfully"),
		@ApiResponse(code = 405, message = "bad request,invalid user id,not proper user data")
	})
	@PutMapping("/user")
	public User updateUser(@RequestParam int id, @RequestBody User user) {
		return userservice.updateUserById(id, user);
	}
	
	@ApiOperation(value = "delete the user by ID", produces = "application/Json", consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 200, message = "user deleted successfully"),
		@ApiResponse(code = 405, message = "bad request,invalid user id")
	})
	@DeleteMapping("/user")
	public void deleteUserById(@RequestParam int id) {
		userservice.deleteUserByID(id);
	}		
}
