package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeDetailsPage extends CommonMethods {

    @FindBy(id ="empsearch_employee_name_empName")
    public static WebElement searchEmployeeName;

    @FindBy(id = "empsearch_id")
    public static WebElement searchEmployeeId;

    @FindBy(id= "#searchBtn")
    public static WebElement searchEmployeeDetailsBtn;

    @FindBy(id ="personal_txtEmpFirstName")
    public static WebElement editFirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public static WebElement editMiddleName;

    @FindBy(id = "personal_txtEmpLastName")
    public static WebElement editLastName;

    @FindBy(id = "personal_txtEmployeeId")
    public static WebElement editEmployeeId;
    public static WebElement selectNatationality;

    @FindBy(id ="btnSave")
    public static WebElement saveButton;

    @FindBy(id = "btnSave")
    public static WebElement editButton;
    public static WebElement NatationalityDropDown;

    @FindBy(id ="personal_optGender_1")
    public WebElement clickMale;

    @FindBy(id ="personal_optGender_2")
    public static WebElement clickFemale;

    @FindBy(id ="personal_cmbNation")
    public WebElement NationalityDropDown;

    @FindBy(id ="personal_cmbMarital")
    public static WebElement maritalStatusDropDown;

    public EmployeeDetailsPage(){PageFactory.initElements(driver,this);
    }


}
