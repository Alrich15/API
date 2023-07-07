package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.IUserRepo;

@Service
public class UpdateServiceImpl implements IUpdateService{
	
	@Autowired
	IUserRepo userRepo;

	@Override
	public void updateFirstName(Integer userId,String firstName) {
//			throws CustomException{
		Optional<Users> userDetails = userRepo.findById(userId);
		
		if(userDetails.get().isLoggedIn()) {
		 userRepo.updateFirstName(userId, firstName);
		}
		else {

			System.out.println("throw userNotLoggedIn exec");
//			throw new CustomException("userNotLoggedIn");
		}
	}

	@Override
	public void updateLastName(Integer userId, String lastName) {
Optional<Users> userDetails = userRepo.findById(userId);
		
		if(userDetails.get().isLoggedIn()) {
		userRepo.updateLastName(userId, lastName);
		}
		else {
			System.out.println("throw userNotLoggedIn exec");
		}
		
	}

	@Override
	public void updateMobile(Integer userId, String mobile) {
Optional<Users> userDetails = userRepo.findById(userId);
		
		if(userDetails.get().isLoggedIn()) {
		userRepo.updateMobile(userId, mobile);
		}
		else {
			System.out.println("throw userNotLoggedIn exec");
		}
		
	}

	@Override
	public void updatePassword(Integer userId, String password) {
Optional<Users> userDetails = userRepo.findById(userId);
		
		if(userDetails.get().isLoggedIn()) {
		userRepo.updatePassword(userId, password);	
		}
		else {
			System.out.println("throw userNotLoggedIn exec");
		}
	}
	
	

}
