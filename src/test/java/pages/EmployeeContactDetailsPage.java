package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeContactDetailsPage extends CommonMethods {

    @FindBy(xpath = "//*[@id=\"sidenav\"]/li[2]/a")
    public WebElement contactDetailsBtn;

    @FindBy(xpath = "//input[@id = 'contact_street1']")
    public  WebElement contactAddressStreet1;

    @FindBy(xpath ="//input[@id = 'contact_street2']")
    public  WebElement contactAddressStreet2;

    @FindBy(xpath = "//input[@id = 'contact_city']")
    public  WebElement contactCity;

    @FindBy(xpath ="//input[@id = 'contact_province']")
    public WebElement contactProvince;

    @FindBy(xpath = "//input[@id = 'contact_emp_zipcode']")
    public WebElement zipPostalCode;


    @FindBy(xpath = "//select[@id = 'contact_country']")
    public WebElement countrydropdown;

    @FindBy(xpath = "//input[@id = 'contact_emp_hm_telephone']")
    public WebElement homeTelephone;

    @FindBy(xpath = "//input[@id = 'contact_emp_mobile']")
    public WebElement mobilePhone;

    @FindBy(xpath = "//input[@id = 'contact_emp_work_telephone']")
    public WebElement workPhone;

    @FindBy(xpath = "//input[@id = 'contact_emp_work_email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@id ='contact_emp_oth_email']")
    public WebElement otherEmailAddress;

    @FindBy(xpath = "//input[@id = 'btnSave']")
    public WebElement saveBtn;

    public EmployeeContactDetailsPage() {
        PageFactory.initElements(driver, this);


    }
}
