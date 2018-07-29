package com.radu.test.spring.store.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "FURNITURE")
@DiscriminatorValue("FURNITURE")
public class FurnitureProduct extends Product {

	@Column(name = "ITEM_NUMBER")
	private Long itemNumber;
	@Column(name = "WEIGHT")
	private BigDecimal weight;
	public Long getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(Long itemNumber) {
		this.itemNumber = itemNumber;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
}
