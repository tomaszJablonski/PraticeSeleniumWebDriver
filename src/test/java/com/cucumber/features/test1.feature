Feature: Test1

  Scenario: Test1
    Given I am on the Google search page
    When I enter any search keyword on search text box
    And I click on search button
    Then I should be redirect to search results page
