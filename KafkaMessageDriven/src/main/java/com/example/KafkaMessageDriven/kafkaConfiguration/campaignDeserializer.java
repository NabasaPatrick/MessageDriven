package com.example.KafkaMessageDriven.kafkaConfiguration;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.KafkaMessageDriven.model.Campaign;
import com.fasterxml.jackson.databind.ObjectMapper;

public class campaignDeserializer implements Deserializer{

	@Override
	public void configure(Map configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	  @Override
	  public Campaign deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper();
	    Campaign user = null;
	    try {
	      user = mapper.convertValue(arg1, Campaign.class);
	    } catch (Exception e) {

	      e.printStackTrace();
	    }
	    return user;
	  }

		@Override 
		public void close() {

		  }
}
