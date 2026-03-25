Feature: Login Functionality
  As a user
  I want to login to the application
  So that I can access the products

  Background:
    Given I am on the login page

  @smoke @ui
  Scenario: Successful login with valid credentials
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click on login button
    Then I should be redirected to products page
    And I should see products displayed

  @regression @ui
  Scenario: Login with invalid credentials
    When I enter username "invalid_user"
    And I enter password "invalid_password"
    And I click on login button
    Then I should see an error message

  @regression @ui
  Scenario Outline: Login with multiple users
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should see "<result>"

    Examples:
      | username        | password     | result           |
      | standard_user   | secret_sauce | products page    |
      | locked_out_user | secret_sauce | error message    |
      | problem_user    | secret_sauce | products page    |


