package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.LinksPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTest extends Base {
    public LinksPage linksPage;

    @BeforeMethod
    public void pageSetUp(){
        linksURL = excelReader.getStringData("Elements", 5, 1);
        linksPage = new LinksPage();
        driver.get(linksURL);
    }

    @Test
    public void userCanClickOnHomeLink() {
        String expectedURL = "https://demoqa.com/";
        String baseHandle = driver.getWindowHandle();
        String currentURL;
        linksPage.clickOnHomeLink();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        currentURL = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(baseHandle);
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test
    public void userCanClickOnHomeDynamicLink(){
        String expectedURL = "https://demoqa.com/";
        String baseHandle = driver.getWindowHandle();
        String currentURL;
        linksPage.clickOnHomeDynamicLink();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        currentURL = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(baseHandle);
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test
    public void checkLinkHasDynamicText(){
        String originalText = linksPage.dynamicLink.getText();
        driver.navigate().refresh();
        Assert.assertNotEquals(linksPage.dynamicLink.getText(), originalText);
    }

    @Test
    public void userCanClickOnCreatedLink(){
        linksPage.clickOnCreatedLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 201 and status text Created");
    }

    @Test
    public void userCanOnNoContentLink(){
        linksPage.clickOnNoContentLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 204 and status text No Content");
    }

    @Test
    public void userCanOnMovedtLink(){
        linksPage.clickOnMovedLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test
    public void userCanOnBadRequestLink(){
        linksPage.clickOnBadRequestLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 400 and status text Bad Request");
    }

    @Test
    public void userCanOnUnauthorizedLink(){
        linksPage.clickOnUnauthorizedLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test
    public void userCanOnForbiddenLink(){
        linksPage.clickOnForbiddenLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 403 and status text Forbidden");
    }

    @Test
    public void userCanOnNotFoundLink(){
        linksPage.clickOnNotFoundLink();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
        Assert.assertEquals(linksPage.linkResponse.getText(), "Link has responded with staus 404 and status text Not Found");
    }
}
