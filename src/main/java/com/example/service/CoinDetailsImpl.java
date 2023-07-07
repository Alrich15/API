package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CoinDetails;
import com.example.repository.CoinDetailsRestClient;
import com.example.repository.ICoinDetailsRepo;

@Service
public class CoinDetailsImpl implements ICoinDetailsService{

	@Autowired
	CoinDetailsRestClient coinDetailsRestClient;
	
	@Autowired
	ICoinDetailsRepo coinDetailsRepo;
	
	@Override
	public CoinDetails getCoinDetails() {
		CoinDetails coinDetails = new CoinDetails();
		coinDetails.setResponse(coinDetailsRestClient.getCoinDetails());
		
		if(! coinDetails.getResponse().isEmpty()) {
			coinDetailsRepo.save(coinDetails);
		}
		else {
			System.out.println("Throw exception");
		}
		return coinDetails;
		
	}

	
	
}
