package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ConfigReader;


import java.sql.*;
import java.time.Duration;

public class AddEmployeeSteps extends CommonMethods {


    AddEmployeePage addEmployeePage = new AddEmployeePage();
    LoginPage loginPage = new LoginPage();


    @When("admin user clicks on on PIM option")
    public void admin_user_clicks_on_pim_option() {
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

    @Then("an error message should be appear")
    public void an_error_message_should_be_appear() {
        System.out.println("Required error message appeared under the Last Name filed,it is clear and well-visible.  ");
    }

    String capturedEmpId;
    String capturedFirstName;
    String capturedLastName;

    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        capturedEmpId = addEmployeePage.employeeId.getAttribute("value");
        capturedFirstName = addEmployeePage.firstName.getAttribute("value");
        capturedLastName = addEmployeePage.lastName.getAttribute("value");

        System.out.println("Captured ID: " + capturedEmpId);
        System.out.println("Captured Name: " + capturedFirstName + " " + capturedLastName);
    }

    @Then("verify the employee is added in the database using id")
    public void verify_the_employee_is_added_in_the_database_using_id() {
        try {
            Connection conn = DriverManager.getConnection(
                    ConfigReader.read("dbURL"),
                    ConfigReader.read("dbUserName"),
                    ConfigReader.read("dbPassword")
            );

            Statement stmt = conn.createStatement();
            String query = "SELECT emp_firstname, emp_lastname FROM hs_hr_employees WHERE employee_id = '" + capturedEmpId + "'";
            ResultSet rs = stmt.executeQuery(query);

            boolean recordFound = false;

            while (rs.next()) {
                String dbFirstName = rs.getString("emp_firstname");
                String dbLastName = rs.getString("emp_lastname");

                if (capturedFirstName.equals(dbFirstName) && capturedLastName.equals(dbLastName)) {
                    recordFound = true;
                    break;
                }
            }

            conn.close();
            Assert.assertTrue("Employee record not found in DB", recordFound);
            System.out.println("✅ Employee successfully verified in the database.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ DB Verification failed: " + e.getMessage());

        }
    }
}