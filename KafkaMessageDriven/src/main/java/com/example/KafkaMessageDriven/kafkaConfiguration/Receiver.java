package com.example.KafkaMessageDriven.kafkaConfiguration;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.KafkaMessageDriven.model.Campaign;
import com.example.KafkaMessageDriven.services.CampaignService;

public class Receiver {
	@Autowired
	private CampaignService cS;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public CountDownLatch getLatch(){
		return latch;
	}
	
	@KafkaListener(topics = "test2to1")
	public void receive(ConsumerRecord<String, Campaign> consumerRecord){
		if(consumerRecord.key().equalsIgnoreCase("insert")){
			cS.insert(consumerRecord.value());
			System.out.println(consumerRecord.key());
		}
		if(consumerRecord.key().equalsIgnoreCase("update")){
			cS.update(consumerRecord.value());
			System.out.println(consumerRecord.key());
		}
		LOGGER.info("received camp='{}'", consumerRecord.toString());
		latch.countDown();
	}
}
