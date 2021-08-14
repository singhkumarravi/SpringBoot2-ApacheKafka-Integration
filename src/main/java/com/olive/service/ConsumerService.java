package com.olive.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olive.message.service.MessageStore;
import com.olive.model.StockData;

@Service
public class ConsumerService {
private static final Logger log=LoggerFactory.getLogger(ConsumerService.class);
	@Autowired
	private MessageStore ms;
	
	@KafkaListener(topics = "${my.kafka.app.topic}",groupId = "groupId")
	public void readData(String message){
		try {
			 log.info("CONSUMER GOT DATA {}",message);
			 StockData stockData = new ObjectMapper().readValue(message, StockData.class);
			 ms.saveData(stockData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
