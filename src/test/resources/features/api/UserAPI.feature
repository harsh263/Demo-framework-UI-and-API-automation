Feature: User API Testing
  As an API consumer
  I want to test user endpoints
  So that I can verify API functionality

  # NOTE: These tests are temporarily disabled with @skip tag
  # The API endpoint is returning 403 Forbidden
  # Remove @skip tag once API access is resolved

  @skip @smoke @api
  Scenario: Get list of users
    Given I have the API endpoint "/users"
    When I send GET request with page "2"
    Then the response status code should be 200
    And the response should contain "data"
    And the response should contain user with id "7"

  @skip @regression @api
  Scenario: Create a new user
    Given I have the API endpoint "/users"
    When I send POST request with following data
      | name | John Doe      |
      | job  | QA Engineer   |
    Then the response status code should be 201
    And the response should contain "name"
    And the response should contain "createdAt"

  @skip @regression @api
  Scenario: Get single user
    Given I have the API endpoint "/users/2"
    When I send GET request
    Then the response status code should be 200
    And the response should contain "data"
    And user first name should be "Janet"





