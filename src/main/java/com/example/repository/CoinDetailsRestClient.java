package com.example.repository;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinDetailsRestClient {
	

	RestTemplate restTemplate = new RestTemplate();
	
private HttpServletRequest request;
    
    @Autowired
    public CoinDetailsRestClient(HttpServletRequest request) {
        this.request = request;
    }
    

	public String getCoinDetails() {

		    HttpHeaders headers = new HttpHeaders();
	        headers.set("X-CMC_PRO_API_KEY", request.getHeader("X-CMC_PRO_API_KEY"));
	        String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETHLTC";

	        RequestEntity<Void> requestEntity = new RequestEntity<>(headers,
	        									HttpMethod.GET, 
	        									URI.create(url));

	        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

	        String responseBody = responseEntity.getBody();
	        System.out.println(responseBody);
	        
	        return responseBody;

	}
	
	
}
