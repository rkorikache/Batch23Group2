Feature: Add employee scenarios

  Background:
    When user enters valid username and password
    And user clicks on login button in add employee flow
    Then user is able to see dashboard page
    When admin user clicks on on PIM option
    And user clicks on Add employee option

  @Diana @withoutID
  Scenario: Without Id
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @Diana @withID
  Scenario: With manually added employeeID
    And user enters firstname, middlename and lastname
    And enters an employeeId manually
    And user clicks on save button
    Then employee added successfully

  @Diana @errorMsg
  Scenario: Error message appearance
    When user enters only firstname
    And user clicks on save button
    Then an error message should be appear


  @Diana @Verify
  Scenario: Verify employee record from the database
    And user enters firstname and lastname
    And user captures the employee id
    And user clicks on save button
    Then verify the employee is added in the database using id