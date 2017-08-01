package com.example.KafkaMessageDriven;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMessageDrivenApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(KafkaMessageDrivenApplication.class);
		Map<String, Object> map = new HashMap<>();
		map.put("SERVER_PORT", "8081");
		app.setDefaultProperties(map);
		app.run(args);
		//SpringApplication.run(KafkaMessageDrivenApplication.class, args);
	}
}
