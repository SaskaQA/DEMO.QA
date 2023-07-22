package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends Base {
    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }


}
