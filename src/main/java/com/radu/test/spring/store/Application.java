package com.radu.test.spring.store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.radu.test.spring.store.entity.FoodProduct;
import com.radu.test.spring.store.entity.Membership;
import com.radu.test.spring.store.entity.ProductDiscount;
import com.radu.test.spring.store.entity.User;
import com.radu.test.spring.store.init.InitDataFactory;
import com.radu.test.spring.store.repository.MembershipRepository;
import com.radu.test.spring.store.repository.ProductRepository;
import com.radu.test.spring.store.repository.UserRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	public CommandLineRunner init(ProductRepository productRepository, MembershipRepository membershipRepository,
			UserRepository userRepository) {
		
		return (args) ->  {

			// fetch all customers
			log.info("Init DB");
			log.info("-------------------------------");
			log.info("Adding products...");

			InitDataFactory.generateProducts().forEach(product -> {
				productRepository.save(product);
			});

			log.info("Adding memberships...");
			Membership membership = new Membership();
			membership.setName("Hotdogs discounts");

			Set<ProductDiscount> discounts = new HashSet<ProductDiscount>();

			productRepository.findAll().forEach(product -> {
				if (product instanceof FoodProduct) {
					ProductDiscount foodDiscounts = new ProductDiscount();
					foodDiscounts.setMembership(membership);
					foodDiscounts.setProduct(product);
					foodDiscounts.setDiscount(new BigDecimal("0.50"));
					discounts.add(foodDiscounts);
				}
			});
			membership.setDiscounts(discounts);
			membershipRepository.save(membership);

			log.info("Adding users...");
			User user = new User();
			user.setFirstName("Fane");
			user.setLastName("Popescu");
			userRepository.save(user);

			User member = new User();
			member.setFirstName("Gigel");
			member.setLastName("Petrescu");
			member.setMembership(membership);
			userRepository.save(member);

			productRepository.findAll().forEach(product -> {
				log.info(product.toString());
			});

			userRepository.findAll().forEach(usr -> {
				log.info(usr.toString());
			});
		};
	}

}
