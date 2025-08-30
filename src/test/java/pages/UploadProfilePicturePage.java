package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class UploadProfilePicturePage extends CommonMethods {

    @FindBy(id = "photofile")
    public WebElement ProfilePhotoUploadButton;

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="btnSave")
    public WebElement SaveButton;


    @FindBy(css = "#addEmployeeTbl div.warning")
    public  WebElement  promptError ;

    public UploadProfilePicturePage(){
        PageFactory.initElements(driver, this);
    }

}