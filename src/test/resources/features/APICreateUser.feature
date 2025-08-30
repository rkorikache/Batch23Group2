

Feature: User Registration API

  @validDetails @api
  Scenario: Successful registration with valid details
    Given the user provides valid registration details with name "Abdel", email "abdel1@gmail.com" and password "abdel123" and send request
    Then the API should respond with "User Created"
    And the response should include the user’s details

  @duplicateEmail @api
  Scenario: Registration fails with duplicate email
    Given the user provides registration details with an existing email "a1@gmail.com" and send request
    Then the API should respond with "The email address you have entered is already registered"

  @invalidEmailFormat @api
  Scenario: Registration fails with invalid email format
    Given the user provides registration details with name "Abdel", Invalid email "abdelgmail.com" and password "abdel123" and send request
    Then the API should respond with "condition" set to "error" and "data" set to "Invalid Email"


  @missingPassWord @api
  Scenario: Registration fails when password is missing
    Given the user provides registration details with name "Abdel" and email "abdel@gmail.com" and empty passord "" and send request
    Then the API respond with "condition" set to "error" and "data" set to "Please fill all inputs"

  @missingName @api
  Scenario: Registration fails when name is missing
    Given the user provides registration details with empty name "" and email "abdel@gmail.com" and password "secret123" and send request
    Then the API respond with "condition" set to "error" and "data" set to "Please fill all inputs"


