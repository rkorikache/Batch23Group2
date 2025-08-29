Feature: Change Employee Personal Details

  Background:
    Given the user is on the HRMS login page
    When the user enters a valid username and password
    And the user clicks on the "Login" button
    Then the user is successfully logged in
    When the user clicks on the "PIM" option

  @EmpDetails
  Scenario: Employee edits personal information
    And the user clicks on the "Employee List" option
    And the user enters "Jane Smith" in the employee name search textbox
    And the user clicks the "Search" button
    And the user selects the employee from the search results
    Then the user should be navigated to the employee's personal details page
    When the user clicks the "Edit" button
    And the user updates the "First Name" to "John"
    And the user updates the "Middle Name" to "A"
    And the user updates the "Last Name" to "Doe"
    And the user selects "Male" as the "Gender"
    And the user selects "American" as the "Nationality"
    And the user selects "Single" as the "Marital Status"
    And the user clicks the "Save" button
    Then a success message should be displayed confirming the changes
    And the updated personal details should be saved in the database
