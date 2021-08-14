package com.olive.message.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olive.model.StockData;
import com.olive.repositiory.StockRepositiory;

@Component
public class MessageStore {
	
private static final Logger log=LoggerFactory.getLogger(MessageStore.class);
	
	@Autowired
	private StockRepositiory repo;
	
	
	public Integer saveData(StockData entity) {
	        repo.save(entity);	
	        log.info("STOCK DATA SAVING IN DATABASE TABLE WITH ID {}",entity.getId());
		return entity.getId();
	}
	
	public List<StockData> getAll(){
		 log.info("FETCHING ALL STOCK DATA FROM DATABASE .....");
		return  repo.findAll(); 
	}
}
