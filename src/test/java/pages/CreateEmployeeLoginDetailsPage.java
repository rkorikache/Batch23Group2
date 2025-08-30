package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class CreateEmployeeLoginDetailsPage extends CommonMethods {


    @FindBy(id = "chkLogin")
    public WebElement credentialCheckboxLoc;

    @FindBy(id = "user_name")
    public WebElement usernameLoc;

    @FindBy(id = "user_password")
    public WebElement passwordLoc;

    @FindBy(id = "re_password")
    public WebElement rePasswordLoc;

    @FindBy(id = "status")
    public WebElement statusLoc;

    @FindBy(id = "btnAddAttachment")
    public WebElement personalDetailPageAddAttachmentLoc;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logoutLoc;


    public CreateEmployeeLoginDetailsPage(){
        PageFactory.initElements(driver,this);
    }

}