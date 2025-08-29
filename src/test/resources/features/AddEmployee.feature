Feature: Add employee scenarios

  Background:
    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on the PIM option
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
    Then an error message should appear

  @Diana @Verify
  Scenario: Verify employee record exists in the database
    Given the employee with ID "88881111" is present in the system
    When I query the database for employee with ID "88881111"
    Then I should get the employee record with name "Livia"