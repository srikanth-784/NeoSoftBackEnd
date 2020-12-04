package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.UserRegistration;
import com.neo.response.UserResponse;
import com.neo.service.RegistrationService;

@RestController
@RequestMapping("/user")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@PostMapping("/createUser")
	ResponseEntity<Object> createUser(@RequestBody UserRegistration registration) {

		UserResponse userResponse = new UserResponse();
		if (registration != null && registration.getUserLogin().getUserName() != null
				&& !registration.getUserLogin().getUserName().isEmpty()
				&& registration.getUserLogin().getPassword() != null
				&& !registration.getUserLogin().getPassword().isEmpty() && registration.getAddress() != null
				&& !registration.getAddress().isEmpty() && registration.getEmailId() != null
				&& !registration.getEmailId().isEmpty() && registration.getMobileNo() != null
				&& !registration.getMobileNo().isEmpty()) {
			UserResponse createUser = registrationService.createUser(registration);
			return new ResponseEntity<Object>(createUser, HttpStatus.OK);
		} else {
			userResponse.setStatusCode("422");
			userResponse.setStatusMessage("request not valid");
			return new ResponseEntity<Object>(userResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PostMapping("/updateUser")
	ResponseEntity<Object> updateUser(@RequestBody UserRegistration registration) {
		UserResponse userResponse = new UserResponse();
		if (registration != null && registration.getUserLogin().getUserName() != null
				&& !registration.getUserLogin().getUserName().isEmpty()
				&& registration.getUserLogin().getPassword() != null
				&& !registration.getUserLogin().getPassword().isEmpty() && registration.getAddress() != null
				&& !registration.getAddress().isEmpty() && registration.getEmailId() != null
				&& !registration.getEmailId().isEmpty() && registration.getMobileNo() != null
				&& !registration.getMobileNo().isEmpty()) {
			UserResponse UpdatedUser = registrationService.updateUser(registration);
			return new ResponseEntity<Object>(UpdatedUser, HttpStatus.OK);
		} else {
			userResponse.setStatusCode("422");
			userResponse.setStatusMessage("request not valid");
			return new ResponseEntity<Object>(userResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	ResponseEntity<Object> deleteUser(@PathVariable("id") long id) {
		UserResponse deleteUser = registrationService.deleteUser(id);
		return new ResponseEntity<Object>(deleteUser, HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{id}")
	ResponseEntity<Object> getByIdUser(@PathVariable("id") long id) {
		UserResponse getByIdUser = registrationService.getByIdUser(id);
		return new ResponseEntity<Object>(getByIdUser, HttpStatus.OK);
	}

	@GetMapping("getAllUsers")
	ResponseEntity<Object> getAllUser() {
		UserResponse allUsers = registrationService.getAllUsers();
		return new ResponseEntity<Object>(allUsers, HttpStatus.OK);
	}

}
