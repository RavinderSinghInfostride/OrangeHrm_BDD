Feature: feature to test login functionality

  Scenario: Check login with valid credentials
    Given user navigates to the login page of the website
    When user enter valid username and password and clicks on the login button
    And user is on the PIM page
    Then browser closes