package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.CommonMethods.driver;

public class AddEmployeeMembershipDetailsPage {

    @FindBy(xpath="//b[normalize-space()='My Info']")
    public WebElement myInfoLoc;

    @FindBy(xpath="//a[normalize-space()='Memberships']")
    public WebElement membershipLoc;

    @FindBy(id="btnAddMembershipDetail")
    public WebElement btnAddMembershipDetailLoc;

    @FindBy(id="btnSaveMembership")
    public WebElement btnSaveMembershipLoc;

    @FindBy(xpath="//span[@for='membership_membership']")
    public WebElement membershipErrorMessageLoc;

    @FindBy(id="membership_membership")
    public WebElement membershipDropDownLoc;

    @FindBy(id="membership_subscriptionPaidBy")
    public WebElement paidByDropDownLoc;

    @FindBy(id="membership_subscriptionAmount")
    public WebElement amountDropDownLoc;

    @FindBy(id="membership_currency")
    public WebElement currencyDropDownLoc;

    @FindBy(id="membership_subscriptionCommenceDate")
    public WebElement subscriptionCommenceDateLoc;

    @FindBy(id="membership_subscriptionRenewalDate")
    public WebElement subscriptionRenewalDateLoc;

    @FindBy(xpath="(//img[@class='ui-datepicker-trigger'])[1]")
    public WebElement firstCalendarIconLoc;

    @FindBy(xpath="(//img[@class='ui-datepicker-trigger'])[2]")
    public WebElement secondCalendarIconLoc;

    @FindBy(css="#listMembershipDetails div.success")
    public WebElement successMessageLoc;

    @FindBy(xpath = "//table//tr[td]")
    public WebElement membershipTableLoc;

    @FindBy(id = "delMemsBtn")
    public WebElement deleteMembershipBtnLoc;

    @FindBy(xpath = "//table//tr[td]//a")
    public WebElement editMembershipLoc;

    public AddEmployeeMembershipDetailsPage(){
        PageFactory.initElements(driver,this);
    }
}
