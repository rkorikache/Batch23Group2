package APIPages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class APICreateEmployeeRecordPage {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTU0NDA3NjIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTc1NTQ4Mzk2MiwidXNlcklkIjoiNzMxNyJ9.Co-aXFlL9lEbRHSrZ7uMaCnsJqkxOpQZLVVzButQTpE";
    static String employee_id;


    @Test
    public void createEmployee(){
        //preparing the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"rabab\",\n" +
                        "  \"emp_lastname\": \"shinde\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2002-05-21\",\n" +
                        "  \"emp_status\": \"permanent\",\n" +
                        "  \"emp_job_title\": \"Manager\"\n" +
                        "}");

        //sending the request
        Response response = request.when().post("/createEmployee.php");

        //validating the response
        response.then().assertThat().statusCode(201);
        //print your response in the console
        response.prettyPrint();
        //using hamcrest matchers, we validate the response body
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("rabab"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("shinde"));
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));

        //storing the employee id
        employee_id =  response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }
}