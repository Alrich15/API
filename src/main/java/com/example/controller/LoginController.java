package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
import com.example.service.ILoginService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	ILoginService loginServ;

	@PostMapping("/login")
	public ResponseEntity<LoginDTO> userLogin(@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
											  @RequestBody LoginDTO loginDto){
		
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return ResponseEntity.accepted()
                .headers(responseHeaders)
                .body(loginServ.userLogin(loginDto));
//		return new ResponseEntity<LoginDTO>(loginServ.userLogin(loginDto), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/logout/{userid}")
	public ResponseEntity<LoginDTO> userLogOut(@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
											   @PathVariable("userid") Integer userId){
		
		
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(loginServ.userLogout(userId));
        
//		return new ResponseEntity<LoginDTO>(loginServ.userLogout(userId), HttpStatus.OK);
	}
}
