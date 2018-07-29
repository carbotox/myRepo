package com.radu.test.spring.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.radu.test.spring.store.Application;
import com.radu.test.spring.store.dto.OrderRequest;

@Service
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public void createOrder(OrderRequest orderRequest) {
		log.info("Saveing new order!");
	}

	public String getOrder(String number) {
		log.info("Finding order! "+number);
		return "This is you order!";
	}
}
