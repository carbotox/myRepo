package com.radu.test.spring.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.radu.test.spring.store.entity.Membership;
import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.init.InitDataFactory;
import com.radu.test.spring.store.repository.MembershipRepository;
import com.radu.test.spring.store.repository.ProductRepository;
import com.radu.test.spring.store.repository.UserRepository;

/**
 * Main Spring boot init application.
 * @author Radu Nicoara
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private InitDataFactory dataFactory;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	/**
	 * Initialize Database with data.
	 * @param productRepository
	 * @param membershipRepository
	 * @param userRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner initDatabase(ProductRepository productRepository, MembershipRepository membershipRepository,
			UserRepository userRepository) {
		
		return (args) ->  {

			log.info("Init DB");
			log.info("Adding products...");

			dataFactory.generateProducts().forEach(product -> {
				productRepository.save(product);
			});

			Iterable<Product> products = productRepository.findAll();
			
			log.info("Adding memberships...");
			Membership membership = membershipRepository.save(dataFactory.generateFoodProductsOffer(products));

			log.info("Adding users...");
			userRepository.save(dataFactory.generateUser("Fane", "Popescu", null));
			userRepository.save(dataFactory.generateUser("Gigel", "Petrescu", membership));


			log.debug("Listing products:");
			productRepository.findAll().forEach(product -> {
				log.info(product.toString());
			});

			log.debug("Listing users:");
			userRepository.findAll().forEach(usr -> {
				log.info(usr.toString());
			});
		};
	}

}
