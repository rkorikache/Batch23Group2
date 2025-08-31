package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeeLanguagePage extends CommonMethods {

    @FindBy(xpath="//a[text()='Employee List']")
    public WebElement EmpListBttn;


    public AddEmployeeLanguagePage(){
        PageFactory.initElements(driver, this);
    }
}
