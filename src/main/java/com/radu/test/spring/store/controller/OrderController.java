package com.radu.test.spring.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.radu.test.spring.store.dto.OrderDTO;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.dto.ProductRequestItem;
import com.radu.test.spring.store.service.OrderService;

@RestController
@RequestMapping("/rest/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value ="/{id}")
	public @ResponseBody OrderDTO getOrder(@PathVariable("id") Long orderId) {
		logger.info("Loading Order. ID="+orderId);
		return orderService.getOrder(orderId);
	}
	
	@PostMapping("/create")
	public void createOrder(@RequestBody OrderRequest orderRequest) {
		logger.info("Creating new Order.");
		orderService.createOrder(orderRequest);
	}

	@GetMapping("/dummyRequest")
	public @ResponseBody OrderRequest getOrderRequest() {
		logger.info("Loading OrderRequest dummy.");
		OrderRequest orderReqDummy = new OrderRequest();
		orderReqDummy.setCustomerId(2l);
		List<ProductRequestItem> products = new ArrayList<ProductRequestItem>();
		ProductRequestItem p1 = new ProductRequestItem();
		p1.setAmount(3);
		p1.setProductId(1l);
		products.add(p1);
		ProductRequestItem p2 = new ProductRequestItem();
		p2.setAmount(1);
		p1.setProductId(2l);
		products.add(p2);
		orderReqDummy.setProducts(products);
		return orderReqDummy;
	}
}
