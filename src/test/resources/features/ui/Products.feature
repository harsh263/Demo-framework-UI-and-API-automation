Feature: Products Management
  As a user
  I want to view and add products to cart
  So that I can purchase items

  Background:
    Given I am logged in as "standard_user" with password "secret_sauce"

  @smoke @ui
  Scenario: View products on products page
    When I am on the products page
    Then I should see multiple products displayed
    And products page title should be "Products"

  @regression @ui
  Scenario: Add product to cart
    When I am on the products page
    And I add first product to cart
    And I click on cart icon
    Then I should see 1 item in the cart

