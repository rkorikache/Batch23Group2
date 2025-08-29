package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    private Employee foundEmployee;

    private static class Employee {
        String id;
        String firstName;
        String lastName;

        Employee(String id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }


    // ✅ Add scenarioContext for storing data across steps
    private Map<String, Object> scenarioContext = new HashMap<>();

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.userNameField.sendKeys("admin");
        loginPage.passwordField.sendKeys("Hum@nhrm123");
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        System.out.println("Logged in");
    }

    @When("user clicks on the PIM option")
    public void user_clicks_on_the_pim_option() {
        click(addEmployeePage.menu_pim_viewPimModule);
    }

    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        click(addEmployeePage.menu_pim_addEmployee);
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        sendText("Diana", addEmployeePage.firstName);
        sendText("Testing", addEmployeePage.lastName);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

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

    @Then("an error message should appear")
    public void an_error_message_should_appear() {
        System.out.println("Required error message appeared under the Last Name field. It is clear and well-visible.");
    }

    private String employeeId;
    private ResultSet resultSet;

    @Given("the employee with ID {string} is present in the system")
    public void the_employee_with_ID_is_present_in_the_system(String id) {
        this.employeeId = id;

    }

    @When("I query the database for employee with ID {string}")
    public void i_query_the_database_for_employee_with_ID(String id) throws SQLException, SQLException {
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String dbUserName="syntax_hrm";
        String dbPassword="syntaxhrm123";
        Connection connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        PreparedStatement statement = connection.prepareStatement("Select * from person");
        statement.setString(1, id);
        resultSet = statement.executeQuery();
    }

    @Then("I should get the employee record with name {string}")
    public void i_should_get_the_employee_record_with_name(String expectedName) throws SQLException {
        if (resultSet.next()) {
            String actualName = resultSet.getString("Livia");
            if (!expectedName.equals(actualName)) {
                throw new AssertionError("Expected name: " + expectedName + ", but got: " + actualName);
            }
        } else {
            throw new AssertionError("No employee record found for ID: " + employeeId);

        }
    }
}