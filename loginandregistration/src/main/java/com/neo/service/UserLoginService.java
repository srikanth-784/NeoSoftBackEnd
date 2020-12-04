package com.neo.service;

import org.springframework.stereotype.Service;

import com.neo.model.UserLogin;
import com.neo.response.UserResponse;
@Service
public interface UserLoginService {

	UserResponse loginUser(UserLogin userLogin);

}
