package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
public class EmployeeContactDetailsPage extends CommonMethods {

    @FindBy(id="contact-details")
    public static WebElement contactDetailsBtn;
    @FindBy(id = "contact_street1")
    public static WebElement contactAddressStreet1;

    @FindBy(id ="contact_street2")
    public static WebElement contactAddressStreet2;

    @FindBy(id ="contact_city")
    public static WebElement contactcity;

    @FindBy(id="contact_province")
    public static WebElement contactStateProvince;

    @FindBy(id="contact_emp_zipcode")
    public static WebElement contactZipPostalCode;

    @FindBy(id="contact_country")
    public static WebElement contactCountryDropDownE;

    @FindBy(id ="contact_emp_hm_telephone")
    public static WebElement contactHomeTelephone;

    @FindBy(id ="contact_emp_mobile")
    public static WebElement contactMobile;

    @FindBy(id="contact_emp_work_telephone")
    public static WebElement contactWorkTelephone;

    @FindBy(id="contact_emp_work_email")
    public static WebElement contactWorkEmail;

    @FindBy(id="contact_emp_work_email")
    public static WebElement contactOtherEmail;

    @FindBy(id="contact_country")
    public static WebElement contactCountryDropDown;

    @FindBy(id="btnSave")
    public static WebElement saveBtn;

    public EmployeeContactDetailsPage(){PageFactory.initElements(driver,this);



}
