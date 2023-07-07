package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.IUpdateService;

@RestController
@RequestMapping("/api/update/")
public class UpdateController {
	
	@Autowired
	IUpdateService updateServ;

	@PatchMapping("{userId}/firstName/{firstName}")
	public ResponseEntity<Void> updateFirstName(@PathVariable("userId") Integer userId,@Valid @PathVariable(value="firstName") String firstName){
		updateServ.updateFirstName(userId,  firstName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("{userId}/lastName/{lastName}")
	public ResponseEntity<Void> updateLastName(@PathVariable("userId") Integer userId,@Valid @PathVariable(value="lastName") String lastName){
		updateServ.updateLastName(userId, lastName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PatchMapping("{userId}/mobile/{mobile}")
	public ResponseEntity<Void> updateMobile(@PathVariable("userId") Integer userId,@Valid @PathVariable(value="mobile") String mobile){
		updateServ.updateMobile(userId, mobile);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PatchMapping("{userId}/password/{password}")
	public ResponseEntity<Void> updatePassword(@PathVariable("userId") Integer userId,@Valid @PathVariable(value="password") String password){
		updateServ.updatePassword(userId, password);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
