package com.radu.test.spring.store.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO object for sending Order to rest client.
 * 
 * @author Radu Nicoara
 *
 */
public class OrderDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8443984890480507314L;

	private Date date;
	private BigDecimal totalPrice;
	private BigDecimal totalPriceDiscount;
	private String customerName;

	private List<OrderItemDTO> orderItems;

	public OrderDTO() {
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

	public BigDecimal getTotalPriceDiscount() {
		return totalPriceDiscount;
	}

	public void setTotalPriceDiscount(BigDecimal totalPriceDiscount) {
		this.totalPriceDiscount = totalPriceDiscount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<OrderItemDTO> getOrderItems() {
		if (orderItems == null) {
			orderItems = new ArrayList<OrderItemDTO>();
		}
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}

}
