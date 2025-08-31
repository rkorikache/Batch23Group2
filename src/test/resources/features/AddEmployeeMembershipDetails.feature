@us11
Feature: Manage membership details on employee profile
  As an employee
  I want to add, edit, and delete my membership details
  So that my HRMS profile is accurate

  Background:
     #Given user is navigated to HRMS application
    When user enters employee username and password
    And user clicks on login button
    Then the user "Rabab" is successfully logged in

  @addMembership @all
  Scenario Outline: Add a membership with valid details
    When user navigates to "My Info" -> "Memberships"
    And user clicks Add membership
    And user saves Membership
    Then user should see "Required" error message
    And user adds membership details:
      | Membership   | PaidBy   | Amount   | Currency   | CommenceDate   | RenewalDate   |
      | <Membership> | <PaidBy> | <Amount> | <Currency> | <CommenceDate> | <RenewalDate> |
    And user saves Membership
    Then use should see a "Successfully Saved" message in memberships
    And the membership row should display:
      | Membership   | PaidBy   | Amount   | Currency   | CommenceDate   | RenewalDate   |
      | <Membership> | <PaidBy> | <Amount> | <Currency> | <CommenceDate> | <RenewalDate> |
    And user should be able to edit or delete the membership
    Examples:
      | Membership | PaidBy     | Amount | Currency | CommenceDate | RenewalDate |
      | aa         | Individual | 120.00 | USD      | 2025-01-01   | 2026-01-01  |
