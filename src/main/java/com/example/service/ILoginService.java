package com.example.service;

import com.example.dto.LoginDTO;

public interface ILoginService {
	
	public LoginDTO userLogin(LoginDTO loginDto);

	public LoginDTO userLogout(Integer userId);

}
