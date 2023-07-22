package DemoQA.Pages.AFW;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends Base {
    public AlertsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "alertButton")
    public WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmButton;

    @FindBy(id = "promtButton")
    public WebElement promtButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResult;

    @FindBy(id = "promptResult")
    public WebElement promptResult;

    public void clickOnAlertButton(){
        alertButton.click();
    }

    public void clickOnTimerAlertButton(){
        timerAlertButton.click();
    }

    public void clickOnConfirmButton(){
        confirmButton.click();
    }

    public void clickOnPromtButton(){
        promtButton.click();
    }
}
