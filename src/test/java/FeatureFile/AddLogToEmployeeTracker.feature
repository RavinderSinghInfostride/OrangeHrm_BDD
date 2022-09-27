Feature: feature to test user can add log to employee tracker

  Scenario: Check user is able to add log to employee tracker
    Given user logins with valid credentials
    When user navigates to the performance page and navigates to the employee tracker page
    And user searches the employee tracker report and clicks the view report button
    Then user clicks the add log button and fill the log details
    And the log is added and the user logs out
    Then the browser closes