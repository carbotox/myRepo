package com.radu.test.spring.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.radu.test.spring.store.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
