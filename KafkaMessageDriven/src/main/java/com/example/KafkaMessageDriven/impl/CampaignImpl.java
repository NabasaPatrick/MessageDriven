package com.example.KafkaMessageDriven.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.KafkaMessageDriven.model.Campaign;
import com.example.KafkaMessageDriven.repo.campaignRepo;
import com.example.KafkaMessageDriven.services.CampaignService;

@Service
public class CampaignImpl implements CampaignService{
	@Autowired
	private campaignRepo cR;
	
	@Override
	public Campaign insert(Campaign camp) {
		// TODO Auto-generated method stub
		if(cR.findOne(camp.getId())==null){
			return cR.save(camp);
		}else{
			return null;
		}
	}

	@Override
	public void update(Campaign camp) {
		// TODO Auto-generated method stub
		Campaign cmpgn = cR.findOne(camp.getId());
		cmpgn.setName(camp.getName());
		cmpgn.setStatus(camp.getStatus());
		
		cR.save(cmpgn);
	} 
}
