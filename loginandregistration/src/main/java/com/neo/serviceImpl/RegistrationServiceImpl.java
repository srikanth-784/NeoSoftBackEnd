package com.neo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.RegistrationDao;
import com.neo.model.UserRegistration;
import com.neo.response.UserResponse;
import com.neo.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDao registrationDao;

	@Override
	public UserResponse createUser(UserRegistration registration) {
		UserResponse response = new UserResponse();
		try {
			UserRegistration savedUser = registrationDao.save(registration);
			List<UserRegistration> userList = new ArrayList<UserRegistration>();
			if (savedUser != null) {
				userList.add(savedUser);
				response.setStatusCode("200");
				response.setUserRegistration(userList);
				response.setStatusMessage("record saved succesfully");
				return response;
			} else {
				response.setUserRegistration(userList);
				response.setStatusMessage("user not saved");
				return response;
			}
		} catch (Exception e) {

			if (e.getMessage().contains("ConstraintViolationException")) {
				response.setStatusCode("422");
				response.setStatusMessage("duplicates are not allowed");
				return response;
			} else {
				response.setStatusCode("422");
				response.setStatusMessage(e.getMessage());
				return response;
			}
		}
	}

	@Override
	public UserResponse getAllUsers() {
		UserResponse response = new UserResponse();
		try {
			List<UserRegistration> list = new ArrayList<>();
			List<UserRegistration> userList = registrationDao.findAll();
			if (userList != null) {
				response.setStatusCode("200");
				response.setUserRegistration(userList);
				response.setStatusMessage("records fetched succesfully");
				return response;
			} else {
				response.setStatusCode("200");
				response.setUserRegistration(list);
				response.setStatusMessage("no records found");
				return response;
			}
		} catch (Exception e) {
			response.setStatusCode("422");
			response.setStatusMessage(e.getMessage());
			return response;
		}

	}

	@Override
	public UserResponse updateUser(UserRegistration registration) {
		UserResponse response = new UserResponse();
		try {
			UserRegistration updatedUser = registrationDao.save(registration);
			List<UserRegistration> userList = new ArrayList<UserRegistration>();
			if (updatedUser != null) {
				userList.add(updatedUser);
				response.setStatusCode("200");
				response.setUserRegistration(userList);
				response.setStatusMessage("record updated succesfully");
				return response;
			} else {
				response.setUserRegistration(userList);
				response.setStatusMessage("user not updated");
				return response;
			}
		} catch (Exception e) {

			if (e.getMessage().contains("ConstraintViolationException")) {
				response.setStatusCode("422");
				response.setStatusMessage("duplicates are not allowed");
				return response;
			} else {

				response.setStatusCode("422");
				response.setStatusMessage(e.getMessage());
				return response;
			}
		}
	}

	@Override
	public UserResponse deleteUser(long id) {
		UserResponse response = new UserResponse();
		try {
			registrationDao.deleteById(id);
			Optional<UserRegistration> userRegistration = registrationDao.findById(id);
			System.out.println("userRegistrationuserRegistration" + userRegistration);
			if (userRegistration != null) {
				response.setStatusCode("200");
				response.setStatusMessage("user deleted succesfully");
				return response;
			}

		} catch (Exception e) {
			if (e.getMessage().contains("exists")) {
				response.setStatusCode("422");
				response.setStatusMessage("User already deleted");
				return response;
			} else {
				response.setStatusCode("422");
				response.setStatusMessage(e.getMessage());
				return response;
			}
		}
		return response;
	}

	@Override
	public UserResponse getByIdUser(long id) {
		UserResponse response = new UserResponse();
		try {
			Optional<UserRegistration> findById = registrationDao.findById(id);
			UserRegistration userRegistration = findById.get();
			List<UserRegistration> userRegistrationList=new ArrayList<>();
			userRegistrationList.add(userRegistration);
			
			//Optional<UserRegistration> userRegistration = registrationDao.findById(id);
			System.out.println("userRegistrationuserRegistration" + userRegistration);
			if (userRegistration != null) {
				response.setUserRegistration(userRegistrationList);
				response.setStatusCode("200");
				response.setStatusMessage("recod fetched succesfully");
				return response;
			}

		} catch (Exception e) {
			if (e.getMessage().contains("exists")) {
				response.setStatusCode("422");
				response.setStatusMessage("User already deleted");
				return response;
			} else {
				response.setStatusCode("422");
				response.setStatusMessage(e.getMessage());
				return response;
			}
		}
		return response;
	}
}
