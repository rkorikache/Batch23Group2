Feature: Change Employee Contact Details

  Background:
    Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Employee List
    And user clicks on Contact Details

  Scenario: Employee updates contact details
    When user updates address line1
    And user updates address line2
    And user updates the City
    And user updates the State/Province
    And user updates the Zip Code/Postal Code
    And user selects the country from the dropdown
    And user updates the home phone number
    And user updates the mobile phone number
    And user updates the work phone number
    And user updates the work email address
    And user updates the other email address
    Then the contact details are saved successfully
