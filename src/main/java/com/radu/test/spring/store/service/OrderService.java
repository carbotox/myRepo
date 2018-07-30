package com.radu.test.spring.store.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radu.test.spring.store.Application;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.entity.Order;
import com.radu.test.spring.store.entity.OrderItem;
import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.repository.OrderRepository;
import com.radu.test.spring.store.repository.ProductRepository;
import com.radu.test.spring.store.repository.UserRepository;

@Service
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public void createOrder(OrderRequest orderRequest) {
		log.info("Saveing new order!");
		
		Order order = new Order();
		order.setCustomer(userRepository.findById(orderRequest.getCustomerId()).get());
		order.setDate(new Date());
		
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderRequest.getProducts().forEach(item->{
			Product product = productRepository.findById(item.getProductId()).get();
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setAmount(item.getAmount());
			orderItem.setTotalPrice(product.getPrice().multiply(new BigDecimal(item.getAmount())));
			orderItems.add(orderItem);
		});
		order.setOrderItems(orderItems);
		orderRepository.save(order);
	}

	public String getOrder(String number) {
		log.info("Finding order! "+number);
		return "This is you order!";
	}
}
