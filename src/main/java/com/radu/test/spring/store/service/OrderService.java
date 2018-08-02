package com.radu.test.spring.store.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.radu.test.spring.store.dto.DTODataMapper;
import com.radu.test.spring.store.dto.OrderDTO;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.entity.Membership;
import com.radu.test.spring.store.entity.Order;
import com.radu.test.spring.store.entity.OrderItem;
import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.repository.OrderRepository;
import com.radu.test.spring.store.repository.ProductRepository;
import com.radu.test.spring.store.repository.UserRepository;

/**
 * Order service layer class.
 * @author Radu Nicoara
 *
 */
@Service
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DTODataMapper dataMapper;
	
	/**
	 * Creates and saves new order.
	 * @param orderRequest
	 * @return id of the new created order
	 */
	@Transactional
	public String createOrder(OrderRequest orderRequest) {
		log.info("Saveing new order!");
		
		Order order = new Order();
		order.setCustomer(userRepository.findById(orderRequest.getCustomerId()).get());
		order.setDate(new Date());
		order.setTotalPrice(BigDecimal.ZERO);
		order.setTotalPriceDiscount(BigDecimal.ZERO);
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderRequest.getProducts().forEach(item->{
			Product product = productRepository.findById(item.getProductId()).get();
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setTotalPrice(BigDecimal.ZERO);
			orderItem.setTotalPriceDiscount(BigDecimal.ZERO);
			orderItem.setProduct(product);
			orderItem.setAmount(item.getAmount());
			orderItem.setTotalPrice(product.getPrice().multiply(new BigDecimal(item.getAmount())));
			orderItem.setTotalPriceDiscount(orderItem.getTotalPrice());
			Membership membership = order.getCustomer().getMembership();
			if (membership != null) {
				membership.getDiscounts().forEach(prodDisc->{
					if (prodDisc.getProduct().equals(product)) {
						orderItem.setTotalPriceDiscount(product.getPrice().multiply(prodDisc.getDiscount()).multiply(new BigDecimal(item.getAmount())));
					}
				});;
			}
			
			orderItems.add(orderItem);
			order.setTotalPrice(order.getTotalPrice().add(orderItem.getTotalPrice()));
			order.setTotalPriceDiscount(order.getTotalPriceDiscount().add(orderItem.getTotalPriceDiscount()));
		});
		order.setOrderItems(orderItems);
		Order savedOrder = orderRepository.save(order);
		log.info(String.format("New order created with id [%d].", savedOrder.getId()));
		return savedOrder.getId()+"";
	}

	/**
	 * Finds order by orderId.
	 * @param orderId
	 * @return
	 */
	public OrderDTO getOrder(Long orderId) {
		log.info(String.format("Loading order id [%d].", orderId));
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		Order order = optionalOrder.get();
		return dataMapper.mapToOrderDTO(order);
	}
}
