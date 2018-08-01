package com.radu.test.spring.store.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.radu.test.spring.store.entity.FoodProduct;
import com.radu.test.spring.store.entity.FurnitureProduct;
import com.radu.test.spring.store.entity.Order;
import com.radu.test.spring.store.entity.OrderItem;
import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.entity.TextileProduct;

@Component
public class DTODataMapper {
	
	private static final Logger log = LoggerFactory.getLogger(DTODataMapper.class);

	public OrderItemDTO mapToOrderItemDTO(OrderItem orderItem) {
		OrderItemDTO dto = new OrderItemDTO();
		dto.setAmount(orderItem.getAmount());
		dto.setTotalPrice(orderItem.getTotalPrice());
		dto.setTotalPriceDiscount(orderItem.getTotalPriceDiscount());
		
		Product product = orderItem.getProduct();
		dto.setProductName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setDescription(product.getDescription());
		
		if (product instanceof FurnitureProduct) {
			dto.setWeight(((FurnitureProduct)product).getWeight());
			dto.setItemNumber(((FurnitureProduct)product).getItemNumber());
		} else if (product instanceof TextileProduct) {
			dto.setColor(((TextileProduct)product).getColor());
			dto.setItemNumber(((TextileProduct)product).getItemNumber());
		}else if (product instanceof FoodProduct) {
			dto.setFlavor(((FoodProduct)product).getFlavor());
		}
		return dto;
	}
	
	public OrderDTO mapToOrderDTO(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setCustomerName(order.getCustomer().getFirstName()+" "+order.getCustomer().getLastName());
		dto.setDate(order.getDate());
		dto.setTotalPrice(order.getTotalPrice());
		dto.setTotalPriceDiscount(order.getTotalPriceDiscount());
		
		order.getOrderItems().forEach(orderItem->{
			log.info("Mapping orderItem entoty to dto."+orderItem);
			dto.getOrderItems().add(mapToOrderItemDTO(orderItem));
		});
		return dto;
	}
}
