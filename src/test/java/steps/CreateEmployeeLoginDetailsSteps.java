package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DBUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CreateEmployeeLoginDetailsSteps extends CommonMethods {

    String expectedUN;
    String expectedFN;
    String expectedMN;
    String expectedLN;
    String empId;


   /* @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        //the benefit of using this method is to get extra facilities available in it.
        //it will wait first for the element to be clickable
        click(pimOption);
    }*/

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeButton);
    }

    @When("I enter the employee information:")
    public void i_enter_the_employee_information(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("FirstName");
        String middleName = data.get(0).get("MiddleName");
        String lastName = data.get(0).get("LastName");

        // Send values to fields
        sendText(firstName, addEmployeePage.firstName);
        sendText(middleName, addEmployeePage.middleName);
        sendText(lastName, addEmployeePage.lastName);

        expectedFN = firstName;
        expectedMN = middleName;
        expectedLN = lastName;

        // grab the employee id from the front end
        empId = addEmployeePage.employeeId.getAttribute("value");
    }

    @And("I check the {string} checkbox")
    public void iCheckTheCheckbox(String checkboxText) {
        click(createEmployeeLoginDetailsPage.credentialCheckboxLoc);
    }

    @And("I enter the employee credential login details:")
    public void iEnterAsTheUsernameAsThePasswordIRetypeInTheConfirmPasswordFieldAndISelectFromTheStatusDropdown(DataTable dataTable) {
        // get today's date
        LocalDateTime today = LocalDateTime.now();

        // extract day and month
        int minute = today.getMinute();
        int second = today.getSecond();

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String username = data.get(0).get("User")+"-"+minute+"-"+second;
        String password = data.get(0).get("Pwd");
        String status = data.get(0).get("EmpStatus");

        sendText(username, createEmployeeLoginDetailsPage.usernameLoc);
        sendText(password, createEmployeeLoginDetailsPage.passwordLoc);
        sendText(password, createEmployeeLoginDetailsPage.rePasswordLoc);
        selectFromDropDown(status, createEmployeeLoginDetailsPage.statusLoc);

        expectedUN = username;
    }

   /* @And("user clicks on save button.")
    public void iClickSave() {
        click(addEmployeePage.saveButton);
    }*/

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        waitForElementToBeClickAble(createEmployeeLoginDetailsPage.personalDetailPageAddAttachmentLoc);
        String query="select emp_firstname,emp_middle_name,emp_lastname from hs_hr_employees where employee_id="+empId;
        List<Map<String,String>> fromDb= DBUtils.fetch(query);
        String actualFN=fromDb.get(0).get("emp_firstname");
        String actualMN=fromDb.get(0).get("emp_middle_name");
        String actualLN=fromDb.get(0).get("emp_lastname");
        Assert.assertEquals(expectedFN,actualFN);
        Assert.assertEquals(expectedMN,actualMN);
        Assert.assertEquals(expectedLN,actualLN);
    }

    @And("user is logged out and redirected to login page")
    public void userIsLoggedOut() {
        click(loginPage.welcomeMessageLoc);
        click(createEmployeeLoginDetailsPage.logoutLoc);
        waitForElementToBeClickAble(loginPage.loginButton);
    }

    @And("I enter the username and password:")
    public void iEnterTheUsernameAndPassword(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String password = data.get(0).get("Pwd");

        sendText(expectedUN, loginPage.userNameField);
        sendText(password, loginPage.passwordField);
    }

    @Then("the user {string} is successfully logged in")
    public void theNewlyCreatedUserIsSuccessfullyLoggedIn(String firstname) {
        //validating the existence of the element
        Assert.assertTrue(loginPage.welcomeMessageLoc.isDisplayed());

        String value = loginPage.welcomeMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertEquals("Welcome " + firstname, value);
    }
}
