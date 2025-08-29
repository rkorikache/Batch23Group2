package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeDetailsPage extends CommonMethods {

    @FindBy(id = "empsearch_employee_name_empName")
    public WebElement searchEmployeeName;

    @FindBy(id = "empsearch_id")
    public WebElement searchEmployeeId;

    @FindBy(id = "searchBtn")
    public WebElement searchEmployeeDetailsBtn;

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement editFirstName;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement editMiddleName;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement editLastName;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement editEmployeeId;

    @FindBy(id = "personal_cmbNation")
    public WebElement NationalityDropDown;

    @FindBy(id = "personal_cmbMarital")
    public WebElement maritalStatusDropDown;

    @FindBy(id = "personal_optGender_1")
    public WebElement clickMale;

    @FindBy(id = "personal_optGender_2")
    public WebElement clickFemale;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "btnSave")
    public WebElement editButton;

    public EmployeeDetailsPage() {
        PageFactory.initElements(driver, this);
    }
}
