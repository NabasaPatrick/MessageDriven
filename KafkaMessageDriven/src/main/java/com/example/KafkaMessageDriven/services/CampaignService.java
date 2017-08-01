package com.example.KafkaMessageDriven.services;

import com.example.KafkaMessageDriven.model.Campaign;

public interface CampaignService {
	public Campaign insert(Campaign camp);
	public void update(Campaign camp);
}
