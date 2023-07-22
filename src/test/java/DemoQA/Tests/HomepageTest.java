package DemoQA.Tests;

import DemoQA.Base.Base;
import DemoQA.Pages.HomepagePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTest extends Base {
    public HomepagePage homepagePage;

    @BeforeMethod
    public void pageSetUp(){
        homepagePage = new HomepagePage();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
    }

    @Test
    public void userCanGoToAllPages(){
        String page1 = "Elements";
        String page2 = "Forms";
        String page3 = "Alerts, Frame & Windows";
        String page4 = "Widgets";
        String page5 = "Interactions";
        String page6 = "Book Store Application";

        homepagePage.clickOnPage(page1);
        Assert.assertTrue(homepagePage.getTextHeader().contains(page1));
        driver.navigate().back();

        homepagePage.clickOnPage(page2);
        Assert.assertTrue(homepagePage.getTextHeader().contains(page2));
        driver.navigate().back();

        homepagePage.clickOnPage(page3);
        Assert.assertTrue(homepagePage.getTextHeader().contains(page3));
        driver.navigate().back();

        homepagePage.clickOnPage(page4);
        Assert.assertTrue(homepagePage.getTextHeader().contains(page4));
        driver.navigate().back();

        homepagePage.clickOnPage(page5);
        Assert.assertTrue(homepagePage.getTextHeader().contains(page5));
        driver.navigate().back();

        homepagePage.clickOnPage(page6);
        Assert.assertTrue(homepagePage.getTextHeader().contains("Book Store"));
    }
}
