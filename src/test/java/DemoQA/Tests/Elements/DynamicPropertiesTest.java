package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.DynamicPropertiesPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends Base {

    public DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeMethod
    public void pageSetUp(){
        dynamicPropertiesURL = excelReader.getStringData("Elements", 8, 1);
        dynamicPropertiesPage = new DynamicPropertiesPage();
        driver.get(dynamicPropertiesURL);
    }

    @Test
    public void verifyTextHasDynamicID() throws InterruptedException {
        String originalID = dynamicPropertiesPage.textWithDynamicID.getAttribute("id");
        driver.navigate().refresh();
        Assert.assertNotEquals(dynamicPropertiesPage.textWithDynamicID.getAttribute("id"), originalID);
    }

    @Test
    public void verifyButtonIsDisabledAtStart(){
        Assert.assertFalse(dynamicPropertiesPage.enableButton.isEnabled());
    }

    @Test
    public void verifyButtonIsEnabledAfterFiveSeconds() throws InterruptedException {
        Thread.sleep(5050);
        Assert.assertTrue(dynamicPropertiesPage.enableButton.isEnabled());
    }

    @Test
    public void verifyColorChangesOnButton() throws InterruptedException {
        String originalColor = dynamicPropertiesPage.colorButton.getCssValue("color");
        Thread.sleep(5050);
        Assert.assertNotEquals(dynamicPropertiesPage.colorButton.getCssValue("color"), originalColor);
    }

    @Test
    public void verifyButtonIsNotVisibleAtStart(){
        Assert.assertThrows(NoSuchElementException.class, () -> dynamicPropertiesPage.visibleButton.isDisplayed());
    }

    @Test
    public void verifyButtonIsVisibleAfterFiveSeconds() throws InterruptedException {
        Thread.sleep(5050);
        Assert.assertTrue(dynamicPropertiesPage.visibleButton.isDisplayed());
    }
}
