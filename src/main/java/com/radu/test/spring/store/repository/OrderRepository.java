package com.radu.test.spring.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.radu.test.spring.store.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
