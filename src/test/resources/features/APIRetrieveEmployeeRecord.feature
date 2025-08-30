Feature: Retrieve Employee Record

  As a tester, I want to validate the API for retrieving an existing employee record using the employee ID,
  So that users can access accurate details of a specific employee

  Background:
    Given the API base URL is set
    And a valid authentication token is generated

@RER1
  Scenario: Retrieve employee details with a valid employee ID
    When the user sends a GET request to retrieve employee with ID "12345"
    Then the API response status code should be 200
    And the response should contain the employee_id "12345"
    And the response should contain "emp_firstname"
    And the response should contain "emp_middle_name"
    And the response should contain "emp_lastname"
    And the response should contain "emp_birthday"
    And the response should contain "emp_gender"
    And the response should contain "emp_job_title"
    And the response should contain "emp_status"
@RER2
  Scenario: Retrieve employee details with an invalid employee ID
    When the user sends a GET request to retrieve employee with ID "99999"
    Then the API response status code should be 404
    And the response should contain the error message "Employee does not exist or you have provided invalid employee_id"
