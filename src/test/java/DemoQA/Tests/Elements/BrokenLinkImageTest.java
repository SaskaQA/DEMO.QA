package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.BrokenLinkImagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkImageTest extends Base {

    public BrokenLinkImagePage brokenLinkImagePage;

    @BeforeMethod
    public void pageSetUP(){
        brokenLinksURL = excelReader.getStringData("Elements", 6, 1);
        brokenLinkImagePage = new BrokenLinkImagePage();
        driver.get(brokenLinksURL);
    }

    @Test
    public void userCanGoToValidLink(){
        String expectedURL = "https://demoqa.com/";
        brokenLinkImagePage.clickOnValidLink();
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @Test
    public void userCantGoToBrokenLink(){
        brokenLinkImagePage.clickOnBrokenLink();
        Assert.assertTrue(brokenLinkImagePage.brokenCode.getText().contains("This page returned a 500 status code."));
    }

    @Test
    public void userCanSeeValidImage(){
        Assert.assertTrue(brokenLinkImagePage.checkForValidImage());
    }

    @Test
    public void userCannotSeeBrokenImage(){
        Assert.assertFalse(brokenLinkImagePage.checkForBrokenImage());
    }
}
