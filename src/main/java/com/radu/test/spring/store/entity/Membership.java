package com.radu.test.spring.store.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEMBERSHIP")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBERSHIP_ID", updatable = false, nullable = false)
	private Long id;
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(
	        mappedBy = "membership", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<ProductDiscount> discounts;
	
	@OneToMany(
	        mappedBy = "membership", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = false
	    )
	private List<User> users;
	

	public List<ProductDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<ProductDiscount> discounts) {
		this.discounts = discounts;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
