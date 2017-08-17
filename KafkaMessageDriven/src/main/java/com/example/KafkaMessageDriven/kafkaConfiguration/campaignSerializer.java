package com.example.KafkaMessageDriven.kafkaConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.example.KafkaMessageDriven.model.Campaign;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.apache.kafka.common.serialization.Serializer;

public class campaignSerializer implements Serializer<Campaign>{

	@Override
	public void configure(Map<String, ?> map, boolean b) {

    }
	
	@Override
    public byte[] serialize(String arg0, Campaign arg1) {
		byte[] retVal = null;
	    ObjectMapper objectMapper = new ObjectMapper();
       try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return retVal;
    }
	
	@Override
    public void close() {

    }


}
