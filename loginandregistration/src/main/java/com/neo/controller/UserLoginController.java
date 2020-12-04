package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.UserLogin;
import com.neo.response.UserResponse;
import com.neo.service.UserLoginService;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	UserLoginService userLoginService;
	@PostMapping("/login")
	ResponseEntity<Object> loginUser(@RequestBody UserLogin  userLogin) {
		UserResponse userResponse = new UserResponse();
		
		if (userLogin != null && userLogin.getUserName() != null
				&& !userLogin.getUserName().isEmpty()
				&& userLogin.getPassword() != null
				&& !userLogin.getPassword().isEmpty()) {
			UserResponse createUser = userLoginService.loginUser(userLogin);
			return new ResponseEntity<Object>(createUser, HttpStatus.OK);
			}else {
				userResponse.setStatusCode("422");
				userResponse.setStatusMessage("request not valid");
			return new ResponseEntity<Object>(userResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	
}
