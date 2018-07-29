package com.radu.test.spring.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.radu.test.spring.store.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByName(String name);
}
