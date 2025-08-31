package APISteps;


import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    public static String token;
    private Response response;

    @Given("a JWT token is generated.")
    public void a_jwt_token_is_generated() {

        // Replace with your API payload
        String payload = "{ \"username\": \"admin\", \"password\": \"Hum@nhrm123\" }";

        // Send POST request
        response = given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("/generateToken.php");

        // Extract token
        token = "Bearer " + response.jsonPath().getString("token");

        System.out.println("Generated Token: " + token);
    }
}
