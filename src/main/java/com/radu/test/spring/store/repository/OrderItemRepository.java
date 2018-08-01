package com.radu.test.spring.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.radu.test.spring.store.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
	public List<OrderItem> findByOrderId(Long orderId);

}
