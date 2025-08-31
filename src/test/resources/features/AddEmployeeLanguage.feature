Feature: Adding Language to Employee in HRM Portal


  Background:
    #Given user is navigated to HRMS application.
    When user enters username and password.
    And user clicks on login button.
    Then user is successfully logged in.
    When user clicks on PIM option..
    And user clicks on Employee List option.


    @AddLanguage @all
    Scenario: Add language to an employee
        When user clicks on an employee
        When user clicks on the Qualifications tab
        And user clicks on the Add Language button
        And user selects a language from the dropdown
        And user selects a fluency level from the dropdown
        And user selects a competency level from the dropdown
        And user enters comments in the comments field
        And user clicks on the Save button
        Then the language should be added successfully to the employee's profile
