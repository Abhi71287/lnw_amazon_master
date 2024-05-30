
Feature: Adding a Monitor Item in Cart and Verifying Subtotal

@Scenario_1
  Scenario: Adding a Monitor Item in Cart and Verifying Subtotal
    Given I am on the Amazon.com homepage
    When I type "Monitor" in the search field
    And I click on search button
    Then I should see a list of monitors displayed
    When I select the first item in the list
    Then I should be on the monitor product page
    When I add the montior item to the cart by clicking on Add to Cart Button
    Then I should see a success message confirming the item is added to the cart
    When I open the cart from the top-left corner
    Then I should be on the cart page
    And the price on the cart page should match the price on the product page
    And the subtotal on the cart page should match the total on the product page
        

@Scenario_2
  Scenario: Adding a Laptop Item in Cart and Verifying Subtotal
    Given I am on the Amazon.com homepage
    When I type "Laptop" in the search field
     And I click on search button
    Then I should see a list of monitors displayed
    When I select the second item in the list
    Then I should be on the laptop product page
    When I add the laptop item to the cart by clicking on Add to Cart Button
    Then I should see a success message confirming the item is added to the cart
    When I open the cart from the top-left corner
    Then I should be on the cart page
    And the price on the cart page should match the price on the product page
    And the subtotal on the cart page should match the total on the product page
    
 @Scenario_3  
    Scenario: Adding Two Items in Cart and Verifying Subtotal
    Given I am on the Amazon.com homepage
    When I type "Headphones" in the search field
    And I click on search button
    Then I should see a list of headphones displayed
    When I select the first item in the list
    Then I should be on the product page for the first item
    And I note the product price for the first item
    When I add the Headphone item to the cart by clicking on Add to Cart Button
    Then I should see a success message confirming the item is added to the cart
    When I enter "Keyboard" in the search field
    And I click on search button
    Then I should see a list of keyboards displayed
    When I select the first item from the  list
    Then I should be on the product page for the second item
    And I note the product price for the second item
    When I add the KeyBoard item to the cart by clicking on Add to Cart Button
    Then I should see a success message confirming the both the items are added to the cart
    When I open the cart from the top-left corner
    Then I should be on the cart page
    And the price of the first item in the cart should match the price on the product page
    And the price of the second item in the cart should match the price on the product page
    And the subtotal on the cart page should be the sum of the prices of the two items