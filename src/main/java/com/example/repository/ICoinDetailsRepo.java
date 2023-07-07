package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.CoinDetails;

@Repository
public interface ICoinDetailsRepo extends JpaRepository<CoinDetails, Integer> {

}
