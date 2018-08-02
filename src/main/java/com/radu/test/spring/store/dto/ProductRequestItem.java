package com.radu.test.spring.store.dto;

import java.io.Serializable;

/**
 * DTO object for get order input.
 * 
 * @author Radu Nicoara
 *
 */
public class ProductRequestItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8212954490311476831L;
	public Long productId;
	public Integer amount;
	
	public ProductRequestItem() {
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
