package com.neo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neo.model.UserLogin;

public interface UserLoginDao extends JpaRepository<UserLogin, Long> {

	@Query(value = "select * from user_login where user_name = :user_name and password = :password", nativeQuery = true)
	UserLogin findUser(String user_name, String password);
}
