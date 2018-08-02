package com.radu.test.spring.store.init;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.radu.test.spring.store.entity.Color;
import com.radu.test.spring.store.entity.FoodProduct;
import com.radu.test.spring.store.entity.FurnitureProduct;
import com.radu.test.spring.store.entity.Membership;
import com.radu.test.spring.store.entity.Product;
import com.radu.test.spring.store.entity.ProductDiscount;
import com.radu.test.spring.store.entity.TextileProduct;
import com.radu.test.spring.store.entity.User;

/**
 * Init database data factory.
 * @author Radu Nicoara
 *
 */
@Component
public class InitDataFactory {
	
	/**
	 * Creates a list  of products.
	 * @return
	 */
	public List<Product> generateProducts(){
		List<Product> products = new ArrayList<Product>();
		FurnitureProduct table = new FurnitureProduct();
		table.setItemNumber(111222333l);
		table.setName("TableABC");
		table.setPrice(new BigDecimal("120"));
		table.setDescription("Extensible wood table");
		table.setWeight(new BigDecimal("19.5"));
		products.add(table);
		
		FurnitureProduct chair = new FurnitureProduct();
		chair.setItemNumber(11144433l);
		chair.setName("Green Chair");
		chair.setPrice(new BigDecimal("35"));
		chair.setDescription("Green PVC small chair.");
		chair.setWeight(new BigDecimal("8.5"));
		products.add(chair);
		
		FurnitureProduct wardrobe = new FurnitureProduct();
		wardrobe.setItemNumber(22233333l);
		wardrobe.setName("Fancy Wardrobe");
		wardrobe.setPrice(new BigDecimal("225"));
		wardrobe.setDescription("Large black wardrobe.");
		wardrobe.setWeight(new BigDecimal("90"));
		products.add(wardrobe);
		
		TextileProduct rug = new TextileProduct();
		rug.setItemNumber(22233333l);
		rug.setName("Red rug");
		rug.setPrice(new BigDecimal("180"));
		rug.setDescription("Red carpet.");
		rug.setColor(Color.RED);
		products.add(rug);
		
		FoodProduct hotDog = new FoodProduct();
		hotDog.setName("Sweet hot dog");
		hotDog.setPrice(new BigDecimal("4"));
		hotDog.setDescription("Sweet hot dog...");
		hotDog.setFlavor("sweet");
		products.add(hotDog);
		
		FoodProduct vegetarianhotDog = new FoodProduct();
		vegetarianhotDog.setName("Vegetarian hot dog");
		vegetarianhotDog.setPrice(new BigDecimal("5"));
		vegetarianhotDog.setDescription("Vegetarian hot dog...");
		vegetarianhotDog.setFlavor("salty");
		products.add(vegetarianhotDog);
		return products;
	}

	/**
	 * Creates Foot Products discount membership.
	 * @param products
	 * @return
	 */
	public Membership generateFoodProductsOffer(Iterable<Product> products){
		Membership membership = new Membership();
		membership.setName("Hotdogs discounts");

		Set<ProductDiscount> discounts = new HashSet<ProductDiscount>();

		products.forEach(product -> {
			if (product instanceof FoodProduct) {
				ProductDiscount foodDiscounts = new ProductDiscount();
				foodDiscounts.setMembership(membership);
				foodDiscounts.setProduct(product);
				foodDiscounts.setDiscount(new BigDecimal("0.50"));
				discounts.add(foodDiscounts);
			}
		});
		membership.setDiscounts(discounts);
		return membership;
	}
	
	/**
	 * Creates User entity.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param membership
	 * @return
	 */
	public User generateUser(String firstName,String lastName, Membership membership){
		User user = new User();
		user.setFirstName("Fane");
		user.setLastName("Popescu");
		user.setMembership(membership);
		return user;
	}
	
}
