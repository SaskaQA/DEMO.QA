package DemoQA.Pages;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends Base {
    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]")
    public WebElement header;

    //-----------------

    public void clickOnPage(String page) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(page)) {
                scrollIntoView(cards.get(i));
                cards.get(i).click();
                break;
            }
        }
    }

    public String getTextHeader(){
        return header.getText();
    }
}
