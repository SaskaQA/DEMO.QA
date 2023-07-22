package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends Base {
    public String textBox;
    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = ("userEmail"))
    public WebElement emailField;

    @FindBy(id = ("currentAddress"))
    public WebElement currentAddressField;

    @FindBy(id = ("permanentAddress"))
    public WebElement permanentAddressField;

    @FindBy(id = ("submit"))
    public WebElement submitButton;

    @FindBy(id = ("output"))
    public WebElement output;

    public void insertFullName(String fullName){
        fullNameField.sendKeys(fullName);
    }

    public void insertEmail(String email){
        emailField.sendKeys(email);
    }

    public void insertCurrentAddress(String address){
        currentAddressField.sendKeys(address);
    }

    public void insertPermanentAddress(String address){
        permanentAddressField.sendKeys(address);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public String getTextOutput(){
        return output.getText();
    }
}
