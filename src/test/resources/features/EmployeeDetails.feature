Feature: Change Employee Personal Details

  Background:
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When admin user clicks on PIM option



  @edit
  Scenario: Employee edits personal information
    And user clicks on Employee List
    And user clicks on Employee Name
    And user enters firstname, lastname, and employeeId
    And user clicks on the search button
    And user selects the employee from the search result
    Then user successfully accesses user personal details
    When user clicks on the edit button
    And user edits firstname, middlename, and lastname
    And user edits gender, nationality, and marital status
    And user clicks on the save button
    Then personal information is saved successfully
