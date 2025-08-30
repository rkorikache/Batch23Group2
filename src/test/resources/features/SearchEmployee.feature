Feature: Search Employee


  Background:
    When user enters valid username and password
    And user clicks on login button in add employee flow
    Then user is able to see dashboard page
    When admin user clicks on on PIM option
    And user clicks on employee list option

  @smoke @lia @rabab @all
  Scenario: Search employee by ID
   # Given user is navigated to HRMS application
   # When user enters username and password
   # And user clicks on login button
   # Then user is successfully logged in
   # When user clicks on PIM option
   # And user clicks on employee list option
    When user enters valid employee id
    And user clicks on search button
    Then user should be able to see employee details


  @smoke @lia @sprint14 @regression @all
  Scenario: Search employee by name
    When user enters valid employee name
    And user clicks on search button
    Then user should be able to see employee details