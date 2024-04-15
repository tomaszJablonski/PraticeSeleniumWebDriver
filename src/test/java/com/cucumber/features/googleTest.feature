Feature: Test1

  @functional
  Scenario: Insert key word tree
    Given I launch the browser
    And I am on the Google search page with url "https://www.google.pl/"
    When I enter any search keyword on search text box
    And I click on search button
    Then I should be redirect to search results page

  @regression
  Scenario: Launch the gmail
    Given I launch the browser
    When I launch the url "https://www.gmail.com/"
    Then I see the login page to the email