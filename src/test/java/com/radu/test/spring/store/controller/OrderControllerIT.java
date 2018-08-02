package com.radu.test.spring.store.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.radu.test.spring.store.Application;
import com.radu.test.spring.store.dto.OrderDTO;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.dto.ProductRequestItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerIT {

	@LocalServerPort
	private int port;

	private URL getOrderURL;
	private OrderRequest orderReq;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.getOrderURL = new URL("http://localhost:" + port + "/rest/order/12");
	}

	@Before
	public void buildOrderRequest() {

		orderReq = new OrderRequest();
		orderReq.setCustomerId(11l);
		List<ProductRequestItem> products = new ArrayList<ProductRequestItem>();
		ProductRequestItem p1 = new ProductRequestItem();
		p1.setAmount(3);
		p1.setProductId(1l);
		products.add(p1);
		ProductRequestItem p2 = new ProductRequestItem();
		p2.setAmount(1);
		p2.setProductId(2l);
		products.add(p2);
		orderReq.setProducts(products);

	}

	@Test
	public void createOrder() throws Exception {
		HttpEntity<OrderRequest> inputEntity = new HttpEntity<OrderRequest>(orderReq);

		ResponseEntity<String> response = template.exchange("http://localhost:" + port + "/rest/order/create", HttpMethod.POST, inputEntity, String.class);
		assertEquals(response.getStatusCodeValue(),201);
		
	}

	@Test
	public void getOrder() throws Exception {
		ResponseEntity<OrderDTO> response = template.getForEntity(getOrderURL.toString(), OrderDTO.class);
		assertEquals(response.getStatusCodeValue(),200);
		OrderDTO orderResult = response.getBody();
		assertEquals(orderResult.getCustomerName(),"Gigel Petrescu");
		assertEquals(orderResult.getTotalPrice(),new BigDecimal("395.00"));
		assertEquals(orderResult.getOrderItems().size(),2);
	}

}
