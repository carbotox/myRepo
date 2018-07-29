package com.radu.test.spring.store;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.init.InitDataFactory;
import com.radu.test.spring.store.repository.ProductRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
	public CommandLineRunner init(ProductRepository productRepository/*, MembershipRepository membershipRepository, UserRepository userRepository*/) {
		return (args) -> {

			// fetch all customers
			log.info("Init DB");
			log.info("-------------------------------");
			log.info("Adding products...");
			
			InitDataFactory.generateProducts().forEach(new Consumer<Product>() {

				@Override
				public void accept(Product t) {
					productRepository.save(t);
				}
			});
			
//			log.info("Adding memberships...");
//			Membership membership = new Membership();
//			membership.setName("Hotdogs discounts");
//			
//			List<ProductDiscount> discounts = new ArrayList<ProductDiscount>();
//			
//			productRepository.findAll().forEach(new Consumer<Product>() {
//
//				@Override
//				public void accept(Product t) {
//					if (t instanceof FoodProduct) {
//						ProductDiscount foodDiscounts = new ProductDiscount();
//						foodDiscounts.setProduct(t);
//						foodDiscounts.setDiscount(new BigDecimal("0.50"));
//						discounts.add(foodDiscounts);
//					}
//					
//				}
//			});
//			membership.setDiscounts(discounts);
//			membershipRepository.save(membership);
//			
//			log.info("Adding users...");
//			User user = new User();
//			user.setFirstName("Fane");
//			user.setLastName("Popescu");
//			userRepository.save(user);
//			
//			User member = new User();
//			member.setFirstName("Gigel");
//			member.setLastName("Petrescu");
//			member.setMembership(membership);
//			userRepository.save(member);
			
			productRepository.findAll().forEach(new Consumer<Product>() {

				@Override
				public void accept(Product product) {
					log.info(product.toString());
					
				}
			});
			
		};
	}

}
