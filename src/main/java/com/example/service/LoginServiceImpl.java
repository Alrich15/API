package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDTO;
import com.example.entity.Users;
import com.example.repository.IUserRepo;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	IUserRepo userRepo;
	@Override
	public LoginDTO userLogin(LoginDTO loginDto) {
		Optional<Users> userDetails = userRepo.findByUserName(loginDto.getUserName());
		
		if(!userDetails.isPresent()) {
			System.out.println("Throw userNotRegistered exec");
		}
		Users dbLogin = userDetails.get();
		if(dbLogin.getUserName().equals(loginDto.getUserName()) && 
				dbLogin.getPassword().equals(loginDto.getPassword())){
			dbLogin.setLoggedIn(true);
			userRepo.save(dbLogin);
			
			LoginDTO login = new LoginDTO();
			login.setUserName(dbLogin.getUserName());
			login.setPassword(dbLogin.getPassword());
			
			return login;
		}
		else {
			System.out.println("Throw Invalid uname,passwd exec");
		return null;	
		}
	}
	@Override
	public LoginDTO userLogout(Integer userId) {
		Optional<Users> userDetails = userRepo.findById(userId);
		
		if(!userDetails.isPresent()) {
			System.out.println("Throw exception");
		}
		Users dbLogout = userDetails.get();
			dbLogout.setLoggedIn(false);
			userRepo.save(dbLogout);
			
			LoginDTO login = new LoginDTO();
			login.setUserName(dbLogout.getUserName());
			login.setPassword(dbLogout.getPassword());
			
			return login;
	}

}
