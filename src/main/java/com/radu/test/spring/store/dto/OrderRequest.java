package com.radu.test.spring.store.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.radu.test.spring.store.dto.ProductRequestItem;

/**
 * DTO object for get order input.
 * 
 * @author Radu Nicoara
 *
 */
public class OrderRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6147771937769627642L;

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
