package Steps;

import Pages.EmployeeContactDetailsPage;
import Pages.LoginPage;
import utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static Pages.EmployeeContactDetailsPage.contactDetailsBtn;
import static Pages.EmployeeContactDetailsPage.saveBtn;


public class EmployeeContactDetailsSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        LoginPage.usernameField.sendKeys("admin");
        LoginPage.passwordField.sendKeys("Hum@nhrm123");
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(LoginPage.loginButton);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        LoginPage loginPage;
        Assert.assertTrue(loginPage.welcomeMessageLoc.isDisplayed());
        String value = loginPage.welcomeMessageLoc.getText();
        Assert.assertEquals("Welcome Admin", value);
        System.out.println("Test passed");
    }

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
    @When("user clicks on Contact Details")
    public void user_clicks_on_contact_details() {
        click(contactDetailsBtn);
    }
    @When("user updates address line1")
    public void user_updates_address_line1() {
        sendText("123 Prosperity Future", EmployeeContactDetailsPage.contactAddressStreet1);
    }
    @When("user updates address line2")
    public void user_updates_address_line2() {
       sendText("Unit 1",EmployeeContactDetailsPage.contactAddressStreet2);
    }
    @When("user updates the City")
    public void user_updates_the_city() {
       sendText("Toronto",EmployeeContactDetailsPage.contactcity);
    }
    @When("user updates the State\\/Province")
    public void user_updates_the_state_province() {
       sendText("Ontario", EmployeeContactDetailsPage.contactStateProvince);
    }
    @When("user updates the Zip Code\\/Postal Code")
    public void user_updates_the_zip_code_postal_code() {
        sendText("A1A 1A1", EmployeeContactDetailsPage.contactZipPostalCode);
    }
    @When("user selects the country from the dropdown")
    public void user_selects_the_country_from_the_dropdown() {
      selectFromDropDown(EmployeeContactDetailsPage.contactCountryDropDown,"Canada");
    }
    @When("user updates the home phone number")
    public void user_updates_the_home_phone_number() {
       sendText("437-777-7777", EmployeeContactDetailsPage.contactHomeTelephone);
    }
    @When("user updates the mobile phone number")
    public void user_updates_the_mobile_phone_number() {
        sendText("437-777-1111",EmployeeContactDetailsPage.contactMobile);
    }
    @When("user updates the work phone number")
    public void user_updates_the_work_phone_number() {
        sendText("416-777-1110",EmployeeContactDetailsPage.contactWorkTelephone);
    }
    @When("user updates the work email address")
    public void user_updates_the_work_email_address() {
        sendText("grantmemoney@icloud.com",EmployeeContactDetailsPage.contactWorkEmail);
    }
    @When("user updates the other email address")
    public void user_updates_the_other_email_address() {
        sendText("grantmoremoney@icloud.com",EmployeeContactDetailsPage.contactOtherEmail);
    }
    @Then("the contact details are saved successfully")
    public void the_contact_details_are_saved_successfully() {
        click(saveBtn);
    }
