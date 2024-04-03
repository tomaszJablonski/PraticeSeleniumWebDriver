Feature: Test1

  Scenario: Test1
    Given I launch the browser "edge"
    And I am on the Google search page with url "https://www.google.pl/"
    When I enter any search keyword on search text box
    And I click on search button
    Then I should be redirect to search results page