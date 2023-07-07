package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CoinDetails;
import com.example.service.ICoinDetailsService;

@RestController
@RequestMapping("/api")
public class CoinDetailsController {
	
	@Autowired
	private ICoinDetailsService coinDetailsServ;
	
	
	@GetMapping("/coin")
	public ResponseEntity<CoinDetails> getCoinDetails(@RequestHeader("X-CMC_PRO_API_KEY") String apiKey){
		return new ResponseEntity<CoinDetails>(coinDetailsServ.getCoinDetails(), HttpStatus.OK);
	}	
}
