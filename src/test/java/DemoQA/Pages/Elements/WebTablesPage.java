package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends Base {
    public WebTablesPage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewRecordButton;

    @FindBy(id = "userForm")
    public WebElement userForm;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "age")
    public WebElement age;

    @FindBy(id = "salary")
    public WebElement salary;

    @FindBy(id = "department")
    public WebElement department;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]") //Useful to check if new record is added as after page reload there are always 3 default records
    public WebElement fourthTableRecord;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]") //Useful after searching for a record
    public WebElement firstTableRecord;

    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id = "basic-addon2")
    public WebElement searchButton;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public boolean isUserFormVisible(){
        return userForm.isDisplayed();
    }

    public void addNewRecord(String firstName, String lastName, String email, String age, String salary, String department){
        addNewRecordButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.userEmail.sendKeys(email);
        this.age.sendKeys(age);
        this.salary.sendKeys(salary);
        this.department.sendKeys(department);
        submitButton.click();
    }

    public void editRecord(int recordNumber,String firstName, String lastName, String email, String age, String salary, String department){
        WebElement editRecordButton = driver.findElement(By.id("edit-record-" + recordNumber));
        editRecordButton.click();
        if (firstName != null){
            this.firstName.clear();
            this.firstName.sendKeys(firstName);
        }
        if (lastName != null){
            this.lastName.clear();
            this.lastName.sendKeys(lastName);
        }
        if (email != null){
            this.userEmail.clear();
            this.userEmail.sendKeys(email);
        }
        if (age != null){
            this.age.clear();
            this.age.sendKeys(age);
        }
        if (salary != null){
            this.salary.clear();
            this.salary.sendKeys(salary);
        }
        if (department != null){
            this.department.clear();
            this.department.sendKeys(department);
        }
        submitButton.click();
    }

    public void deleteRecord(int recordNumber){
        WebElement deleteRecordButton = driver.findElement(By.id("delete-record-" + recordNumber));
        deleteRecordButton.click();
    }

    public void searchForRecord(String record){
        searchBox.sendKeys(record);
        searchButton.click();
    }
}
