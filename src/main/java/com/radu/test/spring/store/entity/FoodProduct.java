package com.radu.test.spring.store.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "FOOD")
//@Table(name="PRODUCT_FOOD")
@DiscriminatorValue("FOOD")
public class FoodProduct extends Product {
	
	@Column(name = "FLAVOR")
	private String flavor;

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	

}
