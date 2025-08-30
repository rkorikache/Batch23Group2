package steps;

import io.cucumber.java.en.*;
import org.apache.commons.math3.analysis.function.Add;
import pages.AddEmployeePage;
import pages.EmployeeContactDetailsPage;
import pages.EmployeeDetailsPage;
import pages.LoginPage;
import utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class EmployeeContactDetailsSteps extends CommonMethods {


    EmployeeContactDetailsPage employeeContactDetailsPage = new EmployeeContactDetailsPage();


    @Given("the employee navigates to the Contact Details section")
    public void the_employee_navigates_to_the_contact_details_section() {
        // Wait until the contact details button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactDetailsBtn = wait.until(ExpectedConditions.elementToBeClickable(employeeContactDetailsPage.contactDetailsBtn));
        contactDetailsBtn.click();

        // Wait until the edit button is clickable
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(employeeDetailsPage.editButton));
        editButton.click();
    }

    @When("user updates address line1 and line2")
    public void user_updates_address_line1_and_line2() {
        sendText("1256AM Future", employeeContactDetailsPage.contactAddressStreet1);
        sendText("F1256A", employeeContactDetailsPage.contactAddressStreet2);
    }

    @When("user updates the city, state and Zip Code")
    public void user_updates_the_city_state_and_zip_code() {
        sendText("Toronto", employeeContactDetailsPage.contactCity);
        sendText("Ontario", employeeContactDetailsPage.contactProvince);
        sendText("M1T 9A9", employeeContactDetailsPage.zipPostalCode);
    }

    @When("user selects the country from the dropdown")
    public void user_selects_the_country_from_the_dropdown() {
       // click(employeeContactDetailsPage.countrydropdown);
        selectFromDropDown( employeeContactDetailsPage.countrydropdown,"Canada");
    }

    @When("user updates the home, mobile and work phone number")
    public void user_updates_the_home_mobile_and_work_phone_number() {
        sendText("489-777-1111", employeeContactDetailsPage.homeTelephone);
        sendText("226-777-0001", employeeContactDetailsPage.mobilePhone);
        sendText("416-777-1010", employeeContactDetailsPage.workPhone);
    }

    @When("user updates the work and other email address")
    public void user_updates_the_work_and_other_email_address() {
        sendText("info@generations.com", employeeContactDetailsPage.emailAddress);
        sendText("info@strategicwealth.com", employeeContactDetailsPage.otherEmailAddress);
    }

    @Then("the contact details are saved successfully")
    public void the_contact_details_are_saved_successfully() {
        System.out.println("Contact Details Saved Successfully");
    }



}



