package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class CoinDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer coinId;
	
	@Lob
	private String response;
}
