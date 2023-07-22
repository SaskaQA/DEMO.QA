package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends Base {
    public LinksPage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "simpleLink")
    public WebElement simpleLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicLink;

    @FindBy(id = "created")
    public WebElement created;

    @FindBy(id = "no-content")
    public WebElement noContent;

    @FindBy(id = "moved")
    public WebElement moved;

    @FindBy(id = "bad-request")
    public WebElement badRequest;

    @FindBy(id = "unauthorized")
    public WebElement unauthorized;

    @FindBy(id = "forbidden")
    public WebElement forbidden;

    @FindBy(id = "invalid-url")
    public WebElement invalidUrl;

    @FindBy(id = "linkResponse")
    public WebElement linkResponse;

    public void clickOnHomeLink(){
        simpleLink.click();
    }

    public void clickOnHomeDynamicLink(){
        dynamicLink.click();
    }

    public void clickOnCreatedLink(){
        created.click();
    }

    public void clickOnNoContentLink(){
        noContent.click();
    }

    public void clickOnMovedLink(){
        moved.click();
    }

    public void clickOnBadRequestLink(){
        badRequest.click();
    }

    public void clickOnUnauthorizedLink(){
        unauthorized.click();
    }

    public void clickOnForbiddenLink(){
        forbidden.click();
    }

    public void clickOnNotFoundLink(){
        invalidUrl.click();
    }

}
