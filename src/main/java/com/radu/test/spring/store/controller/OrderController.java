package com.radu.test.spring.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.service.OrderService;

@RestController
@RequestMapping("/rest")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value ="/salut")
	public String sayHello() {
		return "Hello radu!";
	}
	
	@PostMapping("/newOrder")
	public void createOrder(OrderRequest orderRequest) {
		orderService.createOrder(orderRequest);
	}

	@GetMapping("/getOrder")
	public String greeting(@RequestParam(value = "number") String number) {
		return orderService.getOrder("abc");
	}
}
