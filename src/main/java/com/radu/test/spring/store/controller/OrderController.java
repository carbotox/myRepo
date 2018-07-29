package com.radu.test.spring.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.radu.test.spring.store.model.Order;

@RestController
public class OrderController {

	@RequestMapping("/newOrder")
	public String createOrder(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "New order created!";
	}

	@RequestMapping("/getOrder")
	public Order greeting(@RequestParam(value = "number") String number) {
		return new Order();
	}
}
