Feature: Add items delete unwanted items and place order functionalities

Scenario: User Login
Given User is on login page
When User enter username and password
Then User must be on home page

Scenario Outline: Add multiple items to the cart
Given User is on Home Page
When User adds the product "<item>"
Then Item must be added to cart

Examples: 
	| item |
	| Samsung galaxy s6 |
	| Nexus 6 |

Scenario Outline: Delete unwanted items from cart
Given User is on Cart
When cart contains unwanted items delete them
	| deleteItems |
	| Nexus 6 |
Then item must not be in cart