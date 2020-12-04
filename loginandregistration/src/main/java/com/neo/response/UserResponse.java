package com.neo.response;

import java.util.List;

import com.neo.model.UserRegistration;

public class UserResponse {
	
	private String statusCode;
	private String statusMessage;
	private List<UserRegistration> userRegistration;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public List<UserRegistration> getUserRegistration() {
		return userRegistration;
	}
	public void setUserRegistration(List<UserRegistration> userRegistration) {
		this.userRegistration = userRegistration;
	}
	@Override
	public String toString() {
		return "UserResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", userRegistration="
				+ userRegistration + "]";
	}
	
	

}
