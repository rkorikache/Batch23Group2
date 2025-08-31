

Feature: JWT Token Generation
As a user
I want to generate a JWT token
So that I can use it to access protected APIs
  @GenerateToken @api
  Scenario: Generate JWT token successfully
    Given a JWT token is generated