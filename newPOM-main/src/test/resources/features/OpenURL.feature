Feature: Open Website

  Scenario: Verify the category
    Given Click on category and verify if product displayed

  Scenario: Add product to cart then Checkout and buy product
    Given Click on product
    Then Click on Add to cart
    Then Click on cart from navbar
    Then Verify if item displayed in the cart
    Then click on Place Order button