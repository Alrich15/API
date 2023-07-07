package com.example.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, Integer>{

	@Query(value = "SELECT * FROM users WHERE user_name=:uName", nativeQuery=true)
	Optional<Users> findByUserName(@Param("uName")String userName);

	@Transactional
	@Modifying
	@Query(value="UPDATE users SET first_name=:firstName WHERE user_id=:userId", nativeQuery=true)
	void updateFirstName(@Param("userId") Integer userId,@Param("firstName") String firstName);

	@Transactional
	@Modifying
	@Query(value="UPDATE users SET last_name=:lastName WHERE user_id=:userId", nativeQuery=true)	
	void updateLastName(@Param("userId") Integer userId, @Param("lastName") String lastName);

	@Transactional
	@Modifying
	@Query(value="UPDATE users SET mobile=:mobile WHERE user_id=:userId", nativeQuery=true)	
	void updateMobile(@Param("userId") Integer userId,@Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value="UPDATE users SET password=:password WHERE user_id=:userId", nativeQuery=true)	
	void updatePassword(@Param("userId") Integer userId,@Param("password") String password);
	

}
