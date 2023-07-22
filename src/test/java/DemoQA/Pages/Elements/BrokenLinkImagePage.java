package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BrokenLinkImagePage extends Base {

    public BrokenLinkImagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement validLink;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;

    @FindBy(id = ("content"))
    public WebElement brokenCode;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[1]")
    public WebElement validImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[2]")
    public WebElement brokenImage;

    public void clickOnValidLink(){
        validLink.click();
    }

    public void clickOnBrokenLink() {
        brokenLink.click();
    }

    public boolean checkForValidImage(){
        return isUrlValid(validImage.getAttribute("src"));
    }

    public boolean checkForBrokenImage(){
        return isUrlValid(brokenImage.getAttribute("src"));
    }

    private boolean isUrlValid(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
            if (response.getCode() == 200)
                return true;
            else
                return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
