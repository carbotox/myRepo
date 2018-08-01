package com.radu.test.spring.store.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDR")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID", updatable = false, nullable = false)
	private Long id;
	@Column(name="DATE",nullable = false)
	private Date date;
	@Column(name="TOTAL_PRICE",nullable = false)
	private BigDecimal totalPrice;
	
	@Column(name="TOTAL_PRICE_DISCOUNT",nullable = false)
	private BigDecimal totalPriceDiscount;

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private User customer;
	
	@OneToMany(
	        mappedBy = "order", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = false
	    )
	private List<OrderItem> orderItems;
	
	public Order() {
	}

	public BigDecimal getTotalPriceDiscount() {
		return totalPriceDiscount;
	}

	public void setTotalPriceDiscount(BigDecimal totalPriceDiscount) {
		this.totalPriceDiscount = totalPriceDiscount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}
	
	public User getCustomer() {
		return customer;
	}
	
	public void setCustomer(User customer) {
		this.customer = customer;
	}

}
