package com.olive.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olive.model.StockData;

@Service
public class ProducerService {
private static final Logger log=LoggerFactory.getLogger(ProducerService.class);
	@Autowired
	private KafkaTemplate<String, String> temp;
	
	@Value("${my.kafka.app.topic}")
	private String topic;
	
	
	public void sendData(StockData data) {
		
		try {
			log.info("Producer Sending Data To Kafka ");
			  temp.send(topic, 
					  new ObjectMapper().writeValueAsString(data)
					  );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Send Data SuccesFully");
	}
	
}
