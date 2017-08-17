package com.example.KafkaMessageDriven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.KafkaMessageDriven.kafkaConfiguration.Receiver;
import com.example.KafkaMessageDriven.kafkaConfiguration.Sender;
import com.example.KafkaMessageDriven.model.Campaign;
import com.example.KafkaMessageDriven.services.CampaignService;

@Controller
public class campaignController {
	
	@Autowired
	private CampaignService cS;
	
	@Autowired
	Sender sender;
	
	@Autowired
	Receiver receive;
	
	@PostMapping("/insert")
	public String add(Campaign camp){
		cS.insert(camp);
		sendMessageInsert(camp);
		return "Sukses";
	}
	
	@RequestMapping("/update")
	public String update(Campaign camp){
		cS.update(camp);
		sendMessageUpdate(camp);
		return "Sukses";
	}
	
	//send
	public void sendMessageInsert(Campaign camp) {
		sender.send(camp);
	}
	
	public void sendMessageUpdate(Campaign camp) {
		sender.sendUpdate(camp);
	}	
}
