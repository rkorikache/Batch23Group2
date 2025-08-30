Feature: Login feature

  @LoginAsAdmin @all
  Scenario: Valid admin login
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
