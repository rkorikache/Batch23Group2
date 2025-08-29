Feature: Change Employee Personal Details



  Scenario: Employee edits personal information
    When user clicks on PIM option
    And user clicks on Employee List
    And user clicks on Employee Name
    And user enters firstname, lastname, and employeeId
    And user clicks on the search button
    Then user successfully accesses user personal details
    When user clicks on the edit button
    And user edits firstname, middlename, and lastname
    And user edits gender, nationality, and marital status
    And user clicks on the save button
    Then personal information is saved successfully
