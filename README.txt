Java programming task
You are helping a small startup that wants to compete with IKEA.
They need a simple system that keeps track of product assortment, customers and sold items. Since they want to compete with IKEA, they will sell furniture, textiles, and hot dogs.
A few prerequisites:
Everything sold at the startup has a price and a description
All items in the Furniture category have an item number and a weight (apart from price and description)
All items in the Textile category have an item number and a color (apart from price and description)
Hot dogs have a flavor (apart from price and description), but no item number
Customers can have a membership in the startup. Members get a discount on one or more item categories.
Example 1: A customer buys a carpet and a chili-flavored hot dog. He is not a member, so he doesn’t get any discount.
Example 2: Another customer buys a wardrobe, a rug, and a vegetarian hot dog. She is a member, with furniture and hot dog discounts. So she gets a discount on the wardrobe and the hot dog, but pays normal price for the rug. 

Items, categories and users can be inserted by a sql script or on application startup, no need to manage them

the application should expose REST for :
create order
get order - response should contain products  and discounts

will be nice to use spring boot, as starting point : 
https://spring.io/guides/gs/accessing-data-jpa/
https://spring.io/guides/gs/rest-service/

=====================================================================
login info:
user: user
pass: abc