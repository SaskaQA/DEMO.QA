package DemoQA.Pages.AFW;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends Base {

    public BrowserWindowsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTab;

    @FindBy(id = "windowButton")
    public WebElement newWindow;

    @FindBy(id = "messageWindowButton")
    public WebElement newWindowMessage;


    public void clickOnNewTab(){
        newTab.click();
    }

    public void clickOnNewWindow(){
        newWindow.click();
    }

    public void clickOnNewWindowMessage(){
        newWindowMessage.click();
    }
}
