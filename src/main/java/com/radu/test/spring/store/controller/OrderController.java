package com.radu.test.spring.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/newOrder")
	public void createOrder(@RequestParam(value = "orderRequest") OrderRequest orderRequest) {
		orderService.createOrder(orderRequest);
	}

	@RequestMapping("/getOrder")
	public String greeting(@RequestParam(value = "number") String number) {
		return orderService.getOrder("abc");
	}
}
