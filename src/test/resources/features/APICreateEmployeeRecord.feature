Feature: API

  Background:
    Given a JWT token is generated

  @apiCreateEmployeeDetails @all
  Scenario: create employee with dynamic payload
    Given a request is prepared for creating an employee using data "Rabab" , "Korikache" , "ms" , "F" , "2000-05-21" , "permanent" , "QA Engineer" values
    When a POST call is made to create an employee
    Then the status code for this request is 201
