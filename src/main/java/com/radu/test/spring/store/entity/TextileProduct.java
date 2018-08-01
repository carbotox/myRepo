package com.radu.test.spring.store.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@Table(name="PRODUCT_TEXTILE")
@DiscriminatorValue("TEXTILE")
public class TextileProduct extends Product {
	
	@Column(name = "ITEM_NUMBER")
	private Long itemNumber;
	@Column(name = "COLOR")
	private Color color;
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

}
