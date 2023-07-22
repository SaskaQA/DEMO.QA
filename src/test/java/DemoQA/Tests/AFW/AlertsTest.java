package DemoQA.Tests.AFW;

import DemoQA.Base.Base;
import DemoQA.Pages.AFW.AlertsPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends Base {
    public AlertsPage alertsPage;
    private Alert alert;
    private String expectedMessage;

    @BeforeMethod
    public void pageSetUp(){
        alertsURL = excelReader.getStringData("AFW", 1, 1);
        alertsPage = new AlertsPage();
        driver.get(alertsURL);
    }

    @Test
    public void verifyAlertButton(){
        expectedMessage = "You clicked a button";
        alertsPage.clickOnAlertButton();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedMessage);
    }

    @Test
    public void verifyTimerAlertButton() throws InterruptedException {
        expectedMessage = "This alert appeared after 5 seconds";
        alertsPage.clickOnTimerAlertButton();
        Assert.assertThrows(NoAlertPresentException.class, () -> driver.switchTo().alert());
        Thread.sleep(5050);
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedMessage);
    }

    @Test
    public void verifyConfirmButton(){
        expectedMessage = "Do you confirm action?";
        String confirmMessage = "You selected Cancel";
        alertsPage.clickOnConfirmButton();
        alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.dismiss();
        Assert.assertTrue(alertMessage.equals(expectedMessage) && alertsPage.confirmResult.getText().equals(confirmMessage));
    }

    @Test
    public void verifyPromt() throws InterruptedException {
        expectedMessage = "Some Text I Entered";
        alertsPage.clickOnPromtButton();
        alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(expectedMessage);
        alert.accept();
        Assert.assertEquals(alertsPage.promptResult.getText(), "You entered " + expectedMessage);
    }

    @AfterMethod
    public void Cleanup(){
        try {
            alert.accept();
        }catch (NoAlertPresentException ex){
        }
    }
}
