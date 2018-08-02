package com.radu.test.spring.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.radu.test.spring.store.dto.OrderDTO;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.dto.ProductRequestItem;
import com.radu.test.spring.store.service.OrderService;

/**
 * Order REST controller 
 * @author Radu Nicoara
 *
 */
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
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String createOrder(@RequestBody OrderRequest orderRequest, HttpServletRequest request) {
		logger.info("Creating new Order.");
		String createOrder = orderService.createOrder(orderRequest);
		return "http://localhost:8080/rest/order/"+createOrder; 
	}

	@GetMapping("/dummyRequest")
	public @ResponseBody OrderRequest getOrderRequest() {
		logger.info("Loading OrderRequest dummy.");
		OrderRequest orderReqDummy = new OrderRequest();
		orderReqDummy.setCustomerId(11l);
		List<ProductRequestItem> products = new ArrayList<ProductRequestItem>();
		ProductRequestItem p1 = new ProductRequestItem();
		p1.setAmount(1);
		p1.setProductId(3l);
		products.add(p1);
		ProductRequestItem p2 = new ProductRequestItem();
		p2.setAmount(3);
		p2.setProductId(5l);
		products.add(p2);
		ProductRequestItem p3 = new ProductRequestItem();
		p3.setAmount(2);
		p3.setProductId(6l);
		products.add(p3);
		orderReqDummy.setProducts(products);
		return orderReqDummy;
	}
}
