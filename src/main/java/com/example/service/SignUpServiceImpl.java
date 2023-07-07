package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.IUserRepo;

@Service
public class SignUpServiceImpl implements ISignUpService{

	@Autowired 
	private IUserRepo userRepo;

	@Override
	public Users signUpUser(Users user) {
		Optional<Users> userOpt = userRepo.findByUserName(user.getUserName());
		if(userOpt.isPresent()) {
			System.out.println("User Already exists!!");
			return null;
		}
		return userRepo.save(user);
	}
	
	
}
