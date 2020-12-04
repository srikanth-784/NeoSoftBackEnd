package com.neo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.UserLoginDao;
import com.neo.model.UserLogin;
import com.neo.response.UserResponse;
import com.neo.service.UserLoginService;
import com.neo.utility.UserException;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginDao userLoginDao;

	@Override
	public UserResponse loginUser(UserLogin userLogin) {
		UserResponse userResponse = new UserResponse();
		try {
			UserLogin findUser = userLoginDao.findUser(userLogin.getUserName(), userLogin.getPassword());
			if (findUser != null) {
				userResponse.setStatusCode("200");
				userResponse.setStatusMessage("user logged successfully");
			} else {
				userResponse.setStatusCode("422");
				//userResponse.setStatusMessage("invalid credentials");
				throw new UserException("invalid credentialssssss");
			}
		}
		catch (UserException e) {
			userResponse.setStatusCode("422");
			userResponse.setStatusMessage(e.getMessage());
		}
		catch (Exception e) {
			userResponse.setStatusCode("422");
			userResponse.setStatusMessage(e.getMessage());
		}

		return userResponse;

	}

}
