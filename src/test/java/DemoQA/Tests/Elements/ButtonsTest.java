package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.ButtonsPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends Base {
    String expectedMessage;
    public ButtonsPage buttonsPage;

    @BeforeMethod
    public void pageSetUp() {
        buttonsURL = excelReader.getStringData("Elements", 4, 1);
        buttonsPage = new ButtonsPage();
        driver.get(buttonsURL);
    }

    @Test
    public void doubleClickDoubleClickButtonTest() throws InterruptedException {
        buttonsPage.doubleClick(buttonsPage.doubleClickButton);
        expectedMessage = "You have done a double click";
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), expectedMessage);
    }

    @Test
    public void oneClickDoubleClickButtonTest() throws InterruptedException {
        buttonsPage.clickOnce(buttonsPage.doubleClickButton);
        Assert.assertThrows(NoSuchElementException.class, () -> buttonsPage.doubleClickMessage.getText());
    }

    @Test
    public void rightClickButtonTest() {
        buttonsPage.rightClick(buttonsPage.rightClickButton);
        expectedMessage = "You have done a right click";
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), expectedMessage);
    }

    @Test
    public void clickMeButtonTest() {
        buttonsPage.clickOnce(buttonsPage.clickMeButton);
        expectedMessage = "You have done a dynamic click";
        Assert.assertEquals(buttonsPage.clickMeMessage.getText(), expectedMessage);
    }
}


