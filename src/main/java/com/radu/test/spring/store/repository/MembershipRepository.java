package com.radu.test.spring.store.repository;

import org.springframework.data.repository.CrudRepository;

import com.radu.test.spring.store.entity.Membership;

public interface MembershipRepository extends CrudRepository<Membership, Long>{

}
