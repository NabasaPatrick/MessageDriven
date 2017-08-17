package com.example.KafkaMessageDriven.kafkaConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.KafkaMessageDriven.model.Campaign;

public class Sender {
private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	  @Autowired
	  private KafkaTemplate<String, Campaign> kafkaTemplate;

	  public void send(Campaign camp) {
	    LOGGER.info("sending camp='{}'", camp.toString());
	    kafkaTemplate.send("test1to2","insert", camp);
	  }
	  
	  public void sendUpdate(Campaign camp){
		LOGGER.info("sending update on camp='{}'", camp.toString());
		kafkaTemplate.send("test1to2","update", camp);
	  }
}
