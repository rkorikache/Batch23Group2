package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static utils.PageInitialiser.loginPage;

public class AddEmployeeSteps {

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        sendText(ConfigReaders.read("userName"), loginPage.userName);
        sendText(ConfigReaders.read("password"), loginPage.password);
    }
    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on on PIM option")
    public void user_clicks_on_on_pim_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
