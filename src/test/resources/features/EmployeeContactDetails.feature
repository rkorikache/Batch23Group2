Feature: Change Employee Contact Details

  Background:
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When admin user clicks on on PIM option
    And user clicks on Employee List
    And user clicks on Employee Name
    And user enters firstname, lastname, and employeeId
    And user clicks on the search button
    And user selects the employee from the search result




  Scenario: Employee updates contact details successfully
    When the employee navigates to the Contact Details section
    And user updates address line1 and line2
    And user updates the city, state and Zip Code
    And user selects the country from the dropdown
    And user updates the home, mobile and work phone number
    And user updates the work and other email address
    And user clicks on the save button
    Then the contact details are saved successfully
