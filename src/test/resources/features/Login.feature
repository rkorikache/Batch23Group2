Feature: Login feature

  Background:
    Given the user is on the HRMs login page


  @Login
  Scenario: Valid admin login
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
