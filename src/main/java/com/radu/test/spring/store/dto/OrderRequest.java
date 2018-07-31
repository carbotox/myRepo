package com.radu.test.spring.store.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
	
	public Long customerId;
	
	List<ProductRequestItem> products;
	
	public OrderRequest() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<ProductRequestItem> getProducts() {
		if (products == null) {
			products = new ArrayList<ProductRequestItem>();
		}
		return products;
	}

	public void setProducts(List<ProductRequestItem> products) {
		getProducts().clear();
		getProducts().addAll(products);
	}
	

}
