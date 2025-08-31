@us3
Feature: Create employee login details
  As an HRMS admin
  I want to create login credentials for new employees
  So that they can log in with unique details

  Background:
     #Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    When user clicks on add employee option

  @createLogin @all
  Scenario Outline: Successfully create login details for a new employee
    When I enter the employee information:
      | FirstName | MiddleName | LastName |
      | <First>   | <Middle>   | <Last>   |
    And I check the "Create Login Details" checkbox
    And I enter the employee credential login details:
      | User         | Pwd          | EmpStatus  |
      | <Username>   | <Password>   | <Status>   |
    And user clicks on save button
    Then employee is added successfully
    And user is logged out and redirected to login page
    And I enter the username and password:
      | Pwd          |
      | <Password>   |
    When user clicks on login button
    Then the user "<First>" is successfully logged in

    Examples:
      | First   | Middle | Last  | Username     | Password       | Status   |
      | Rabab   |  ms    | Test  | rabab.test   | Test@2025#HR   | Enabled  |
