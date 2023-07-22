package DemoQA.Pages.Forms;

import DemoQA.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeFormPage extends Base {

    public PracticeFormPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(id = "gender-radio-1")
    public WebElement maleRadioButton;

    @FindBy(id = "gender-radio-2")
    public WebElement femaleRadioButton;

    @FindBy(id = "gender-radio-3")
    public WebElement otherRadioButton;

    @FindBy(id = "userNumber")
    public WebElement mobiileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "subjectsContainer")
    public WebElement subjectField;

    @FindBy(id = "hobbies-checkbox-1")
    public WebElement sportsBox;

    @FindBy(id = "hobbies-checkbox-2")
    public WebElement readingBox;

    @FindBy(id = "hobbies-checkbox-3")
    public WebElement musicBox;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "state")
    public WebElement stateList;

    @FindBy(id = "city")
    public WebElement cityList;

    public void inputFirstName(String name){
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String lastname){
        lastNameField.sendKeys(lastname);
    }

    public void inputEmail(String email){
        userEmailField.sendKeys(email);
    }

    public void clickMaleRadioButton() {
        clickButton(maleRadioButton);
    }

    public void clickFemaleRadioButton() {
        clickButton(femaleRadioButton);
    }

    public void clickOtherRadioButton() {
        clickButton(otherRadioButton);
    }

    public void inputMobileNumber(String number){
        mobiileNumberField.sendKeys(number);
    }

    public void inputDateOfBirth(){// metoda koja menja value
        dateOfBirthInput.sendKeys();
    }

    public void inputSubject(String subject){
        subjectField.sendKeys(subject);
    }

    public void selectSports(){
        clickButton(sportsBox);
    }

    public void selectReading(){
        clickButton(readingBox);
    }

    public void selectMusic(){
        clickButton(musicBox);
    }

    private void clickButton(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void chooseFile(String filePath){
        uploadPicture.sendKeys(filePath);
    }

    public void inputCurrentAddress(String address){
        currentAddressField.sendKeys(address);
    }

    public void stateListSelectFirstOption(){
        stateList.click();
        WebElement firstItem = driver.findElement(By.id("react-select-3-option-0"));
        firstItem.click();
    }

    public void cityListSelectFirstOption(){
        cityList.click();
        WebElement firstItem = driver.findElement(By.id("react-select-3-option-0"));
        firstItem.click();
    }
}
