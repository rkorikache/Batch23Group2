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
        WebElement empListButton = driver.findElement(By.id("menu_pim_viewEmployeeList"));
    }

    @When("user clicks on Employee Name")
    public void user_clicks_on_employee_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters firstname, lastname, and employeeId")
    public void user_enters_firstname_lastname_and_employee_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user successfully accesses user personal details")
    public void user_successfully_accesses_user_personal_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the edit button")
    public void user_clicks_on_the_edit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user edits firstname, middlename, and lastname")
    public void user_edits_firstname_middlename_and_lastname() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user edits gender, nationality, and marital status")
    public void user_edits_gender_nationality_and_marital_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("personal information is saved successfully")
    public void personal_information_is_saved_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}


