Feature: Change Employee Personal Details

  Background:
    Given the user is on the HRMS login page
    When the user enters a valid username and password
    And the user clicks on the "Login" button
    Then the user is successfully logged in
    When the user clicks on the "PIM" option

  @EmpDetails
  Scenario: Employee edits personal information
    And user clicks on the "Employee List" option
    And user enters "Jane Smith" in the employee name search textbox
    And user clicks the "Search" button
    And user selects the employee from the search results
    Then user should be navigated to the employee's personal details page
    When user clicks the "Edit" button
    And user updates the "First Name" to "John"
    And user updates the "Middle Name" to "A"
    And user updates the "Last Name" to "Doe"
    And user selects "Male" as the "Gender"
    And user selects "American" as the "Nationality"
    And user selects "Single" as the "Marital Status"
    And user clicks the "Save" button
    Then a success message should be displayed confirming the changes
    And the updated personal details should be saved in the database
