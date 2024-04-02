Feature: Login Test

  Scenario: Successful login when user logs in with valid login credentials
    Given I am on the customer login page
    When I provide valid login credentials
    And I click on login button
    Then I should be redirect to home page