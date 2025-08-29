package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstant;


import static io.restassured.RestAssured.given;

public class APICreateEmployeeRecordSteps {


    String baseURI = RestAssured.baseURI = APIConstants.baseURI;
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTYzNDYwMTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTc1NjM4OTIxNywidXNlcklkIjoiNzQxOSJ9.x-qp8i6VIUfA_aPYsEb0EJWvY3WOHthAzeetybiZGKc";
    static String employee_id;
    RequestSpecification request;
    Response response;

    @Given("a JWT token is generated")
    public void a_jwt_token_is_generated() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstant.jsonPayloadGenerateJWT());

        response = request.when().post("/generateToken.php");

        token = "Bearer " + response.jsonPath().getString("token");
    }


    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response = request.when().post(APIConstants.CREATE_EMPLOYEE);
    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        //print your response in the console
        response.prettyPrint();
        //using hamcrest matchers, we validate the response body

    }

    @Given("a request is prepared for creating an employee using data {string} , {string} , {string} , {string} , {string} , {string} , {string} values")
    public void a_request_is_prepared_for_creating_an_employee_using_data_values(
            String fn, String ln, String mn,
            String gender, String birthday,
            String status, String jobtitle) {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token).
                body(APIPayloadConstant.jsonPayloadMoreDynamic(null, fn, ln,mn,gender,birthday,status,jobtitle));
    }
}