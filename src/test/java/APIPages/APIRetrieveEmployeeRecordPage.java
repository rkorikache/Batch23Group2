package APIPages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.CommonMethods;

public class APIRetrieveEmployeeRecordPage {

    private final String BASE_ENDPOINT = "/employees/";

    public Response getEmployeeById(String employeeId) {
        return RestAssured
                .given()
                .log().all()
                .get(BASE_ENDPOINT + employeeId);
    }

    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public void setAuthToken(String token) {
        RestAssured.requestSpecification = RestAssured
                .given()
                .header("Authorization", "Bearer " + token);
    }

    public void clearRequestSpecification() {
        RestAssured.requestSpecification = null;
    }
}
