package com.radu.test.spring.store;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.dto.ProductRequestItem;

public class MyHelper {
	public static void main(String[] args) {
		OrderRequest orderRea = new OrderRequest();
		orderRea.setCustomerId(2l);
		List<ProductRequestItem> products = new ArrayList<ProductRequestItem>();
		ProductRequestItem p1 = new ProductRequestItem();
		p1.setAmount(3l);
		p1.setProductId(1l);
		products.add(p1);
		ProductRequestItem p2 = new ProductRequestItem();
		p2.setAmount(1l);
		p1.setProductId(2l);
		products.add(p2);
		orderRea.setProducts(products);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(orderRea);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(json);
	}
	

}
