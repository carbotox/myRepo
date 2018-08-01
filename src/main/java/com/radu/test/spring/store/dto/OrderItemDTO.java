package com.radu.test.spring.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.radu.test.spring.store.entity.Color;

public class OrderItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7109975187359279586L;
	private Long id;
	private String productName;
	private BigDecimal price;
	private String description;
	private Long itemNumber;
	private Color color;
	private Integer amount;
	private BigDecimal weight;
	private String flavor;
	private BigDecimal totalPrice;
	private BigDecimal totalPriceDiscount;

	public OrderItemDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalPriceDiscount() {
		return totalPriceDiscount;
	}

	public void setTotalPriceDiscount(BigDecimal totalPriceDiscount) {
		this.totalPriceDiscount = totalPriceDiscount;
	}

}
