package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Users;
import com.example.service.ISignUpService;

@RestController
@RequestMapping("api")
public class SignUpController {
	
	@Autowired
	ISignUpService signUpServ;

	@PostMapping("/signup/user")
	public ResponseEntity<Users> signUpUser(@RequestHeader(HttpHeaders.CONTENT_TYPE) String type,
											@RequestBody Users user) {

		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(signUpServ.signUpUser(user));
        
//		return new ResponseEntity<Users>(signUpServ.signUpUser(user),HttpStatus.OK);
	}
	
}
