package APISteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APICreateUserSteps {

    String baseURI = RestAssured.baseURI = APIConstants.baseURI;
    RequestSpecification request;
    Response response;


   @Given("the user provides valid registration details with name {string}, email {string} and password {string} and send request")
   public void user_provides_valid_details_and_sends_request(String userName, String userEmail, String userPassword) {
       String requestBody = "{ " +
               "\"name\": \"" + userName + "\", " +
               "\"email\": \"" + userEmail + "\", " +
               "\"password\": \"" + userPassword + "\" }";
       response = given()
               .header("Content-Type", "application/json")
               .body(requestBody)
               .when()
               .post(APIConstants.baseURI);
       response.prettyPrint();
       response.then().assertThat().body("Message", equalTo("User Created"));
   }
    public Response getResponse() {
        return response;
    }
    @Then("the API should respond with {string}")
    public void the_api_should_respond_with_message(String expectedMessage) {
        response.then()
                .statusCode(201)
                .body("Message", equalTo(expectedMessage));
    }
    @And("the response should include the user’s details")
    public void response_should_include_user_details() {

        response.then().assertThat()
                .body("name", equalTo("Abdel"))
                .body("email", equalTo("abdel@gmail.com"))
                .body("password", equalTo("abdel123"));
    }



    @Given("the user provides registration details with an existing email {string} and send request")
    public void user_provides_existing_email(String existingEmail) {
        String requestBody = "{ " +
                "\"name\": \"Abdel\", " +
                "\"email\": \"" + existingEmail + "\", " +
                "\"password\": \"abdel123\" " +
                "}";
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(APIConstants.baseURI);

        response.prettyPrint();
    }


    @Given("the user provides registration details with name {string}, Invalid email {string} and password {string} and send request")
    public void theUserProvidesRegistrationDetailsWithNameInvalidEmailAndPasswordAndSendRequest(String userName, String userEmail, String userPassword) {

        String requestBody = "{ " +
                "\"name\": \"" + userName + "\", " +
                "\"email\": \"" + userEmail + "\", " +
                "\"password\": \"" + userPassword + "\" " +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(APIConstants.baseURI);  //

        response.prettyPrint();

    }

    @Then("the API should respond with {string} set to {string} and {string} set to {string}")
    public void api_should_respond_with_error_and_data(String condition, String error, String data, String value) {
       String expectedEmail = "Invalid Email";
        response.then().assertThat()
                .statusCode(400)
                .body(condition, equalTo(error))
                .body(data, equalTo(expectedEmail));

    }


    @Given("the user provides registration details with name {string} and email {string} and empty passord {string} and send request")
    public void theUserProvidesRegistrationDetailsWithNameAndEmailAndEmptyPassordAndSendRequest(String userName, String userEmail, String userPassword) {

        String requestBody = "{ " +
                "\"name\": \"" + userName + "\", " +
                "\"email\": \"" + userEmail + "\", " +
                "\"password\": \"" + userPassword + "\" " +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(APIConstants.baseURI);  //

        response.prettyPrint();
    }

    @Then("the API respond with {string} set to {string} and {string} set to {string}")
    public void theAPIRespondWithSetToAndSetTo(String condition, String error, String data, String value) {
       String exValue = "Please fill all inputs";
        response.then().assertThat()
                .statusCode(400)
                .body(condition, equalTo(error))
                .body(data, equalTo(exValue));

    }

    @Given("the user provides registration details with empty name {string} and email {string} and password {string} and send request")
    public void theUserProvidesRegistrationDetailsWithEmptyNameAndEmailAndPasswordAndSendRequest(String userName, String userEmail, String userPassword) {

        String requestBody = "{ " +
                "\"name\": \"" + userName + "\", " +
                "\"email\": \"" + userEmail + "\", " +
                "\"password\": \"" + userPassword + "\" " +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(APIConstants.baseURI);  //

        response.prettyPrint();
    }

    }


