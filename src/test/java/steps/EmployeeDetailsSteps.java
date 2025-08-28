package steps;

import pages.EmployeeDetailsPage;
import pages.LoginPage;
import utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EmployeeDetailsSteps extends CommonMethods {


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimOption);
    }

    @When("user clicks on Employee List")
    public void user_clicks_on_employee_list() {
        WebElement employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(employeeList);
    }

    @When("user clicks on Employee Name")
    public void user_clicks_on_employee_name() {
        WebElement employeeName = driver.findElement(By.id("empsearch_employee_name_empName"));
        click(employeeName);
    }

    @When("user enters firstname, lastname, and employeeId")
    public void user_enters_firstname_lastname_and_employee_id() {
        sendText("Nhu Nguyen", EmployeeDetailsPage.searchEmployeeName);
        sendText("119798A", EmployeeDetailsPage.searchEmployeeId);
    }

    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        click(EmployeeDetailsPage.searchEmployeeDetailsBtn);

    }

    @Then("user successfully accesses user personal details")
    public void user_successfully_accesses_user_personal_details() {
        System.out.println("Successfully accesses user personal details.");
    }

    @When("user clicks on the edit button")
    public void user_clicks_on_the_edit_button() {
        click(EmployeeDetailsPage.editButton);
    }

    @When("user edits firstname, middlename, and lastname")
    public void user_edits_firstname_middlename_and_lastname() {
        sendText("Trang", EmployeeDetailsPage.editFirstName);
        sendText("Nhu", EmployeeDetailsPage.editMiddleName);
        sendText("Pham", EmployeeDetailsPage.editLastName);
    }

    @When("user edits gender, nationality, and marital status")
    public void user_edits_gender_nationality_and_marital_status() {
        click(EmployeeDetailsPage.clickFemale);
        selectFromDropDown(EmployeeDetailsPage.NatationalityDropDown, "Vietnamese");
        selectFromDropDown(EmployeeDetailsPage.maritalStatusDropDown, "Single");

    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        click(EmployeeDetailsPage.saveButton);
    }

    @Then("personal information is saved successfully")
    public void personal_information_is_saved_successfully() {
        System.out.println("Personal information is saved successfully.");
    }
}
