package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class APIRetrieveEmployeeRecordSteps {

    Response response;

    @Given("the API base URL is set")
    public void the_api_base_url_is_set() {
        RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    }

    @Given("a valid authentication token is generated")
    public void a_valid_authentication_token_is_generated() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTYzMzUzNjMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTc1NjM3ODU2MywidXNlcklkIjoiNzQyNCJ9.iZ2IBBT6JTlGcLx4ygR0Rgq__b8ivr-Cpi-2PSZqMsU")
                .build();
    }

    @When("the user sends a GET request to retrieve employee with ID {string}")
    public void the_user_sends_a_get_request_to_retrieve_employee_with_id(String employeeId) {
        response = RestAssured
                .given()
                .log().all()
                .get("/employees/" + employeeId);
    }

    @Then("the API response status code should be {int}")
    public void the_api_response_status_code_should_be(Integer expectedStatusCode) {
        response.then().log().all().statusCode(expectedStatusCode);
    }

    @Then("the response should contain the employee_id {string}")
    public void the_response_should_contain_the_employee_id(String employeeId) {
        response.then().body("employee_id", equalTo(employeeId));
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String employee_id) {
        response.then().body("$", hasKey(employee_id));
    }

    @Then("the response should contain the error message {string}")
    public void the_response_should_contain_the_error_message(String expectedError) {
        response.then().body("error", equalTo(expectedError));
    }
}
