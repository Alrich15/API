package com.example.service;

public interface IUpdateService {

	public void updateFirstName(Integer userId, String firstName);

	public void updateLastName(Integer userId, String lastName);

	public void updateMobile(Integer userId, String mobile);

	public void updatePassword(Integer userId, String password);

	
}
