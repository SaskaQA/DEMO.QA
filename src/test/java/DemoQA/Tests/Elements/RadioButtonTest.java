package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends Base {

    String expectedMessage;
    public RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        radioButtonURL = excelReader.getStringData("Elements", 2, 1);
        radioButtonPage = new RadioButtonPage();
        driver.get(radioButtonURL);
    }

    @Test
    public void clickOnYesRadioButton() {
        radioButtonPage.clickRadioButton(radioButtonPage.yesRadioButton);
        expectedMessage = "You have selected Yes";
        Assert.assertEquals(radioButtonPage.responseMessage.getText(), expectedMessage);
    }

    @Test
    public void clickOnImpressiveRadioButton() {
        radioButtonPage.clickRadioButton(radioButtonPage.impressiveRadioButton);
        expectedMessage = "You have selected Impressive";
        Assert.assertEquals(radioButtonPage.responseMessage.getText(), expectedMessage);
    }

    @Test
    public void isNoRadioButtonDisabled() {
        radioButtonPage.clickRadioButton(radioButtonPage.noRadioButton);
        expectedMessage = "You have selected No";
        Assert.assertEquals(radioButtonPage.responseMessage.getText(), expectedMessage);
    }
}
