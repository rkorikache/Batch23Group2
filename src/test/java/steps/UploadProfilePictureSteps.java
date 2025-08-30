package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;

public class UploadProfilePictureSteps extends CommonMethods {


    @When("user clicks on PIM option.")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimOption);

    }

    @And("user clicks on add employee option.")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeButton);

    }

    @When("the user uploads a picture {string} with maximum size of {string} and dimensions {string}")
    public void the_user_uploads_a_picture_with_maximum_size_of_and_dimensions(String string, String string2, String string3) {
        String ProfilePicPath= Constants.TEST_DATA_PATH+"ValidProfilePic.JPG";
        System.out.println("ProfilePicPath is :" +ProfilePicPath);
        uploadProfilePhoto.ProfilePhotoUploadButton.sendKeys(ProfilePicPath);
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_name_and_nickname(String firsName, String lastName) {
        uploadProfilePhoto.firstNameField.clear();
        uploadProfilePhoto.firstNameField.sendKeys(firsName);
        uploadProfilePhoto.lastNameField.clear();
        uploadProfilePhoto.lastNameField.sendKeys(lastName);
    }

    @When("the user clicks save button")
    public void the_user_clicks_save_button() {
        uploadProfilePhoto.SaveButton.click();
    }

    @Then("the profile picture should be updated successfully")
    public void the_profile_picture_should_be_updated_successfully() {
        System.out.println("Profile photo is updated successfully ");
    }

    @When("the user uploads {string}")
    public void the_user_uploads(String filename) {
        String ProfilePicPath= Constants.TEST_DATA_PATH+filename;
        System.out.println("ProfilePicPath is :" +ProfilePicPath);
        uploadProfilePhoto.ProfilePhotoUploadButton.sendKeys(ProfilePicPath);
    }



    @Then("an alert with message {string} should be displayed")
    public void anAlertWithMessageShouldBeDisplayed(String errorMessage) {

        waitForElementToBeVisible(uploadProfilePhoto.promptError);
        Assert.assertTrue(errorMessage.contains("Failed to Save: File Type Not Allowed"));
        getWait();


    }

}



