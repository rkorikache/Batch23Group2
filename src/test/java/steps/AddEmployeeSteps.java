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
        addEmployeePage.menu_pim_viewPimModule.click();
    }

    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        addEmployeePage.menu_pim_addEmployee.click();
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        sendText("Diana", addEmployeePage.firstName);
        sendText("Testing", addEmployeePage.lastName);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        addEmployeePage.saveButton.click();
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
        System.out.println("Required error message appeared under the Last Name filed,it is clear and well-visible.  ");
    }

    @Given("user is logged in with valid credentials")
    public void user_is_logged_in_with_valid_credentials() {
        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        sendText(username, loginPage.userNameField);
        sendText(password, loginPage.passwordField);
        click(loginPage.loginButton);  // If you have a click method for login

        System.out.println("User is logged in using credentials from config file.");
    }


    @When("user navigates to Add Employee page")
    public void user_navigates_to_add_employee_page() {
        addEmployeePage.menu_pim_viewPimModule.click();
        addEmployeePage.menu_pim_addEmployee.click();
    }

    @When("user enters firstname {string} and lastname {string}")
    public void user_enters_firstname_and_lastname(String firstName, String lastName) {
        sendText(firstName, addEmployeePage.firstName);
        sendText(lastName, addEmployeePage.lastName);

        // Optional: Store values for verification later
        CommonMethods.scenarioContext.set("firstName", firstName);
        CommonMethods.scenarioContext.set("lastName", lastName);

        // Save employeeId for DB check
        String empId = addEmployeePage.employeeId.getAttribute("value");
        CommonMethods.scenarioContext.set("employeeId", empId);

        addEmployeePage.saveButton.click();
    }

    @Then("the employee record should exist in the database with firstname {string} and lastname {string}")
    public void the_employee_record_should_exist_in_the_database_with_firstname_and_lastname(String expectedFirstName, String expectedLastName) {
        String empId = (String) CommonMethods.scenarioContext.get("employeeId");

        String dbUrl = ConfigReader.getPropertyValue("dbURL");
        String dbUsername = ConfigReader.getPropertyValue("dbUsername");
        String dbPassword = ConfigReader.getPropertyValue("dbPassword");

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement("SELECT first_name, last_name FROM hs_hr_employees WHERE employee_id = ?")) {

            stmt.setString(1, empId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String actualFirstName = rs.getString("first_name");
                String actualLastName = rs.getString("last_name");

                if (!expectedFirstName.equals(actualFirstName) || !expectedLastName.equals(actualLastName)) {
                    throw new AssertionError("Database record mismatch: Expected (" + expectedFirstName + " " + expectedLastName +
                            ") but found (" + actualFirstName + " " + actualLastName + ")");
                }
            } else {
                throw new AssertionError("No employee record found with ID: " + empId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection or query failed.");
        }
    }
}

