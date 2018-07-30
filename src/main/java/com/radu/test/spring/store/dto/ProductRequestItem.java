package com.radu.test.spring.store.dto;

public class ProductRequestItem {

	public Long productId;
	public Long amount;
	
	public ProductRequestItem() {
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
