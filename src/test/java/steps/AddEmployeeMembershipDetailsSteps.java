package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class AddEmployeeMembershipDetailsSteps extends CommonMethods {

    @When("user enters employee username and password")
    public void userEntersEmployeeUsernameAndPassword() {
        sendText(ConfigReader.read("empUsername"), loginPage.userNameField);
        sendText(ConfigReader.read("empPassword"), loginPage.passwordField);
    }

    @When("user navigates to {string} -> {string}")
    public void userNavigatesTo(String menu1, String menu2) {

        click(addEmployeeMembershipDetailsPage.myInfoLoc);
        click(addEmployeeMembershipDetailsPage.membershipLoc);
    }

    @And("user clicks Add membership")
    public void userClicksAddMembership() {
        click(addEmployeeMembershipDetailsPage.btnAddMembershipDetailLoc);
    }


    @And("user saves Membership")
    public void userSavesMembership() {
        click(addEmployeeMembershipDetailsPage.btnSaveMembershipLoc);
    }

    @Then("user should see {string} error message")
    public void userShouldSeeRequiredErrorMessage(String errMsg) {
        Assert.assertTrue(addEmployeeMembershipDetailsPage.membershipErrorMessageLoc.isDisplayed());

        String value = addEmployeeMembershipDetailsPage.membershipErrorMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertEquals(errMsg, value);
    }

    @And("user adds membership details:")
    public void userAddsMembershipDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String membership = data.get(0).get("Membership");
        String paidBy = data.get(0).get("PaidBy");
        String amount = data.get(0).get("Amount");
        String currency = data.get(0).get("Currency");
        String commenceDate = data.get(0).get("CommenceDate");
        String renewalDate = data.get(0).get("RenewalDate");

        // Send values to fields
        selectFromDropDown(addEmployeeMembershipDetailsPage.membershipDropDownLoc, membership);
        selectFromDropDown(paidBy, addEmployeeMembershipDetailsPage.paidByDropDownLoc);
        sendText(amount, addEmployeeMembershipDetailsPage.amountDropDownLoc);
        selectFromDropDown(currency, addEmployeeMembershipDetailsPage.currencyDropDownLoc);



        // driver.findElement(By.xpath("(//img[@class='ui-datepicker-trigger'])[1]")).click();
        click(addEmployeeMembershipDetailsPage.subscriptionCommenceDateLoc);
        sendText(commenceDate, addEmployeeMembershipDetailsPage.subscriptionCommenceDateLoc);
        click(addEmployeeMembershipDetailsPage.firstCalendarIconLoc);


        click(addEmployeeMembershipDetailsPage.subscriptionRenewalDateLoc);
        sendText(renewalDate, addEmployeeMembershipDetailsPage.subscriptionRenewalDateLoc);
        click(addEmployeeMembershipDetailsPage.secondCalendarIconLoc);
        //  driver.findElement(By.xpath("(//img[@class='ui-datepicker-trigger'])[2]")).click();

    }

    @Then("use should see a {string} message in memberships")
    public void useShouldSeeAMessageInMemberships(String successMsg) {
        waitForElementToBeVisible(addEmployeeMembershipDetailsPage.successMessageLoc);
        Assert.assertTrue(addEmployeeMembershipDetailsPage.successMessageLoc.isDisplayed());

        String value = addEmployeeMembershipDetailsPage.successMessageLoc.getText();
        //validating the exact message on the element
        Assert.assertTrue(value.contains(successMsg));

    }

    @And("the membership row should display:")
    public void theMembershipRowShouldDisplay(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        String[] expected = {null, data.get(0).get("Membership"), data.get(0).get("PaidBy"), data.get(0).get("Amount"), data.get(0).get("Currency"), data.get(0).get("CommenceDate"), data.get(0).get("RenewalDate")};

        // Get all cells of that row
        List<WebElement> cells = addEmployeeMembershipDetailsPage.membershipTableLoc.findElements(By.tagName("td"));

        for (int i = 1; i < expected.length; i++) {
            String actualText = cells.get(i).getText().trim();
            Assert.assertEquals(expected[i], actualText);
        }

    }

    @And("user should be able to edit or delete the membership")
    public void userShouldBeAbleToEditOrDeleteTheMembership() {

        Assert.assertTrue(addEmployeeMembershipDetailsPage.deleteMembershipBtnLoc.isDisplayed());
        Assert.assertTrue(addEmployeeMembershipDetailsPage.editMembershipLoc.isDisplayed());
    }
}