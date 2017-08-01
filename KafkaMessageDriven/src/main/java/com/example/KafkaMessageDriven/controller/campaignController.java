package com.example.KafkaMessageDriven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.KafkaMessageDriven.model.Campaign;
import com.example.KafkaMessageDriven.services.CampaignService;

@Controller
public class campaignController {
	
	@Autowired
	private CampaignService cS;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
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
	    kafkaTemplate.send("client2to1", camp);
	}
	
	public void sendMessageUpdate(Campaign camp) {
	    kafkaTemplate.send("client2to1", camp);
	}
	
	//listen
	@KafkaListener(topics = "client1to2", group = "foo")
	public void listenInsert(Campaign camp) {
	   cS.insert(camp); 
	}
	
	@KafkaListener(topics = "client1to2", group = "foo")
	public void listenUpdate(Campaign camp) {
		   cS.insert(camp); 
		}
	
	
	
	
}
