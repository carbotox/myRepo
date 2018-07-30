package com.radu.test.spring.store.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ITEM_ID", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
	private Product product;
	
	@Column(name="AMOUNT",nullable = false)
	private Long amount;
	
	@Column(name="TOTAL_PRICE", nullable = false)
	private BigDecimal totalPrice;
	
	public OrderItem() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}
	
	
	

}
