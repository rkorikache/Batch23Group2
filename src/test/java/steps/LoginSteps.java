package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class LoginSteps extends CommonMethods {
    @Given("the user is on the HRMs login page")
    public void the_user_is_on_the_hr_ms_login_page() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.userNameField.sendKeys("admin");
        loginPage.passwordField.sendKeys("Hum@nhrm123");

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        //validating the existence of the element
        Assert.assertTrue(loginPage.welcomeMessageLoc.isDisplayed());

        String value = loginPage.welcomeMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertEquals("Welcome Admin", value);
        System.out.println("Test passed");
    }
    }


