package com.olive.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olive.message.service.MessageStore;
import com.olive.model.StockData;
import com.olive.service.ProducerService;

@RestController
@RequestMapping("/api/stock")
public class StockDataRestController {
@Autowired
private MessageStore ms;
@Autowired
private ProducerService ps;

	@PostMapping("/send")
	public String sendToKafka(@RequestBody StockData data) {
		 ps.sendData(data);
		return "SENT SUCCESSFULLY";
	}
	
	
	@GetMapping("/all")
	public List<StockData> getAllData(){
		
		return ms.getAll();
				
	}
}
