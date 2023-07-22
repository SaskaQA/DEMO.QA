package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends Base {

    public DynamicPropertiesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/p")
    public WebElement textWithDynamicID;

    @FindBy(id = "enableAfter")
    public WebElement enableButton;

    @FindBy(id = "colorChange")
    public WebElement colorButton;

    @FindBy(id = "visibleAfter")
    public WebElement visibleButton;

}
