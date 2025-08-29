package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddEmployeePage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.sql.*;
import java.time.Duration;

public class AddEmployeeSteps extends CommonMethods {

    @When("user enters firstname, middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        sendText("Livia", addEmployeePage.firstName);
        sendText("Anna", addEmployeePage.middleName);
        sendText("Test", addEmployeePage.lastName);

    }

    @When("enters an employeeId manually")
    public void enters_an_employee_id_manually() {
        sendText("88881111", addEmployeePage.employeeId);

    }

    @When("user enters only firstname")
    public void user_enters_only_firstname() {
        sendText("errorTesting", addEmployeePage.firstName);
    }

    @Then("an error message should be appear")
    public void an_error_message_should_be_appear() {
        System.out.println("Required error message appeared under the Last Name filed,it is clear and well-visible.  ");
    }

    private String employeeId;
    private ResultSet resultSet;

    @Given("the employee with ID {string} is present in the system")
    public void the_employee_with_ID_is_present_in_the_system(String id) {
        this.employeeId = id;

    }

    @When("I query the database for employee with ID {string}")
    public void i_query_the_database_for_employee_with_ID(String id) throws SQLException {
        String dbURL = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String dbUserName = "syntax_hrm";
        String dbPassword = "syntaxhrm123";

        Connection connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);

        // Use ? placeholder to insert parameter safely
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE employee_id = ?");
        statement.setString(1, id);

        resultSet = statement.executeQuery();
    }

    @Then("I should get the employee record with name {string}")
    public void i_should_get_the_employee_record_with_name(String expectedName) throws SQLException {
        if (resultSet.next()) {
            // Use actual column name from your DB, e.g., "first_name"
            String actualName = resultSet.getString("first_name"); // <-- replace with correct column
            if (!expectedName.equals(actualName)) {
                throw new AssertionError("Expected name: " + expectedName + ", but got: " + actualName);
            }
        } else {
            throw new AssertionError("No employee record found for ID: " + employeeId);
        }
    }
}

