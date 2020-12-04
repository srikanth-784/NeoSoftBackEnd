package com.neo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.neo.model.UserRegistration;

public interface RegistrationDao extends JpaRepository<UserRegistration, Long> {

//	@Modifying
//	@Transactional
//	@Query(value = "delete from user_login where id = select user_login_id from user_registration where id=:id", nativeQuery = true)
//	public int deleteUserLogin(long id);
//	
//	@Modifying
//	@Transactional
//	@Query(value = "delete from user_address where id = select address_id from user_registration_address where user_registration_id=:id", nativeQuery = true)
//	public int deleteUserAddress(long id);
//	
//	@Modifying
//	@Transactional
//	@Query(value = "delete from user_registration where id =:id", nativeQuery = true)
//	public int deleteUser(long id);
}