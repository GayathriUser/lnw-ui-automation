#Author: Gaya3
@Amazon
@Cart-category
@add-to-Cart
@Single
@Multiple
Feature: Add to cart 
  Adding a single and multiple items to the cart and validate product price and sub-total

  @Single
  Scenario Outline: add a "<product_name>" to the cart and verify product page price and cart sub-total price
    Given I Search for an item "<product_name>" and click on search button
    And verify the search result displays a list of products
    When I Select the <product_position> item from the product list
    And I navigate to the product page and save the product "<product_price>"
    And I add the item to the cart by clicking on add to cart button
    And I navigate to cart page by clicking cart icon
    Then verify the cart page price is same as product page "<product_price>"
    And verify the subtotal price on cart page is same as product page "<product_price>"

    Examples: 
      | product_name  | product_position | product_price |
      | Monitor       |     1            | Monitor_price |
      | Laptop        |     2            | Laptop_price  |
      
 @mutiple    
  Scenario Outline: Add multiple product to the cart and verify the sub total
    Given I Search for an item "<product_name1>" and click on search button
    And verify the search result displays a list of products
    When I Select the <product_position1> item from the product list
    And I navigate to the product page and save the product "<product_price1>"
    And I add the item to the cart by clicking on add to cart button
    And I Search for an item "<product_name2>" and click on search button
    And verify the search result displays a list of products
    When I Select the <product_position2> item from the product list
    And I navigate to the product page and save the product "<product_price2>"
    And I add the item to the cart by clicking on add to cart button
    And I navigate to cart page by clicking cart icon
    Then verify the cart page price is same as product page "<product_price2>,<product_price1>"
    And verify the subtotal price on the cart page matches the product sum "<product_price2>,<product_price1>" 

    Examples: 
      | product_name1  | product_position1 | product_price1  |product_name2   | product_position2 | product_price2 |
      | Headphone      |     1             | HeadphonePrice |Keyboard        |     1             | KeyboardPrice |
 
