package com.example.KafkaMessageDriven.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.KafkaMessageDriven.model.Campaign;

public interface campaignRepo extends JpaRepository<Campaign, Integer> {

}
