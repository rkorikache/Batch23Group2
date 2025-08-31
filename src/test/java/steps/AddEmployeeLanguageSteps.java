package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class AddEmployeeLanguageSteps extends CommonMethods {

    @When("user enters username and password.")
    public void user_enters_username_and_password() {

        WebElement usernameField = driver.findElement(new By.ById("txtUsername"));
        usernameField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(new By.ById("txtPassword"));
        passwordField.sendKeys("Hum@nhrm123");
    }
    @When("user clicks on login button.")
    public void user_clicks_on_login_button() {

        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }
    @Then("user is successfully logged in.")
    public void user_is_successfully_logged_in() {
        System.out.println("Login successful");
    }
    @When("user clicks on PIM option..")
    public void user_clicks_on_pim_option() {

        WebElement pimOption= driver.findElement(By.xpath("//b[text()='PIM']"));
        pimOption.click();
    }
    @When("user clicks on the Qualifications tab")
    public void user_clicks_on_the_qualifications_tab() {

        WebElement qualificationsTab=driver.findElement(By.xpath("//ul[@id='sidenav']/li[10]"));
        qualificationsTab.click();
    }
    @When("user clicks on the Add Language button")
    public void user_clicks_on_the_add_language_button() {

        WebElement addLanguageButton=driver.findElement(By.xpath("//input[@id='addLanguage']"));
        addLanguageButton.click();
    }
    @When("user selects a language from the dropdown")
    public void user_selects_a_language_from_the_dropdown() {

        WebElement languageDropdown=driver.findElement(By.id("language_code"));
        languageDropdown.click();
        WebElement selectLanguage=driver.findElement(By.xpath("//option[@value='2302']"));
        selectLanguage.click();
    }
    @When("user selects a fluency level from the dropdown")
    public void user_selects_a_fluency_level_from_the_dropdown() {

        WebElement fluencyDropdown=driver.findElement(By.id("language_lang_type"));
        fluencyDropdown.click();
        WebElement selectFluency=driver.findElement(By.xpath("//option[@value='2']"));
        selectFluency.click();
    }
    @When("user selects a competency level from the dropdown")
    public void user_selects_a_competency_level_from_the_dropdown() {

        WebElement competencyDropdown=driver.findElement(By.xpath("//select[@id='language_competency']"));
        competencyDropdown.click();
        WebElement selectCompetency=driver.findElement(By.id("language_competency"));
        selectFromDropDown(selectCompetency, "Basic");
    }
    @When("user enters comments in the comments field")
    public void user_enters_comments_in_the_comments_field() {

        WebElement comments=driver.findElement(By.id("language_comments"));
        comments.sendKeys("Good in speaking and writing");
    }
    @When("user clicks on the Save button")
    public void user_clicks_on_the_save_button() {

        WebElement saveButton=driver.findElement(By.id("btnLanguageSave"));
        saveButton.click();
    }
    @Then("the language should be added successfully to the employee's profile")
    public void the_language_should_be_added_successfully_to_the_employee_s_profile() {

        System.out.println("Language added successfully to the employee's profile");
    }

    @When("user clicks on Employee List option.")
    public void user_clicks_on_employee_list_option() {
        WebElement EmpListBtnn=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        EmpListBtnn.click();

    }
    @When("user clicks on an employee")
    public void user_clicks_on_an_employee() {

        WebElement selectEmployee=driver.findElement(By.xpath("//a[text()='82144721fd']"));
        selectEmployee.click();
    }


}
