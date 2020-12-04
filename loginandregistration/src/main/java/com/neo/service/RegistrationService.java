package com.neo.service;

import org.springframework.stereotype.Service;

import com.neo.model.UserRegistration;
import com.neo.response.UserResponse;

@Service
public interface RegistrationService {

	UserResponse createUser(UserRegistration registration);

	UserResponse getAllUsers();

	UserResponse updateUser(UserRegistration registration);

	UserResponse deleteUser(long id);
	
	UserResponse getByIdUser(long id);
}