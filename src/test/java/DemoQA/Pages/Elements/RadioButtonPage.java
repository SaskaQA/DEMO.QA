package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends Base {
    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "yesRadio")
    public WebElement yesRadioButton;

    @FindBy (id = "impressiveRadio")
    public WebElement impressiveRadioButton;

    @FindBy (id = "noRadio")
    public WebElement noRadioButton;

    @FindBy (className = "mt-3")
    public WebElement responseMessage;

    public void clickRadioButton(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }
}

