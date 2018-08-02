package com.radu.test.spring.store.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.radu.test.spring.store.SecurityConfig;
import com.radu.test.spring.store.dto.OrderDTO;
import com.radu.test.spring.store.dto.OrderItemDTO;
import com.radu.test.spring.store.dto.OrderRequest;
import com.radu.test.spring.store.entity.Color;
import com.radu.test.spring.store.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	private OrderDTO order;

	@MockBean
	private OrderRequest orderReq;

	private String expected = "{\"date\":null,\"totalPrice\":10,\"totalPriceDiscount\":1,\"customerName\":\"Test1 Test2\",\"orderItems\":[{\"productName\":\"Acadele\",\"price\":1,\"description\":\"Prea dulci\",\"color\":\"RED\",\"amount\":5}]}";
	private String exampleRequestJson = "{\"customerId\":11,\"products\":[{\"productId\":6,\"amount\":3},{\"productId\":4,\"amount\":1}]}";

	@Before
	public void buildOrder() {
		order = new OrderDTO();
		order.setCustomerName("Test1 Test2");
		order.setTotalPrice(BigDecimal.TEN);
		order.setTotalPriceDiscount(BigDecimal.ONE);

		OrderItemDTO orderItem = new OrderItemDTO();
		orderItem.setProductName("Acadele");
		orderItem.setColor(Color.RED);
		orderItem.setDescription("Prea dulci");
		orderItem.setAmount(5);
		orderItem.setPrice(BigDecimal.ONE);
		order.setOrderItems(Arrays.asList(orderItem));

	}

	@Test
	public void getOrder() throws Exception {

		Mockito.when(orderService.getOrder(Mockito.anyLong())).thenReturn(order);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/order/1").with(httpBasic(SecurityConfig.USER_NAME, SecurityConfig.USER_PASSWORD)).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void createOrder() throws Exception{

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/rest/order/create").with(httpBasic(SecurityConfig.USER_NAME, SecurityConfig.USER_PASSWORD))
				.accept(MediaType.APPLICATION_JSON).content(exampleRequestJson)
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andReturn();
	
	}

}
