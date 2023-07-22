package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends Base {
    public TextBoxPage textBoxPage;

    @BeforeMethod
    public void pageSetUp(){
        textBoxURL = excelReader.getStringData("Elements", 0, 1);
        textBoxPage = new TextBoxPage();
        driver.get(textBoxURL);
    }

    @Test
    public void checkSubmit_AllFieldsArePopulated(){
        String name = "Bob Adams";
        String email = "testmail@test.com";
        String currentAddress = "Banana Street 123, Big City";
        String permanentAddress = "Orange Street 321, Big Village";

        textBoxPage.insertFullName(name);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        String outputText = textBoxPage.getTextOutput();

        Assert.assertTrue(outputText.contains(name)
                            && outputText.contains(email)
                            && outputText.contains(currentAddress)
                            && outputText.contains(permanentAddress)
        );
    }

    @Test
    public void checkSubmit_EmailInInvalidFormat() throws InterruptedException {
        String name = "Bob Adams";
        String email = "testmailcom";
        String currentAddress = "Banana Street 123, Big City";
        String permanentAddress = "Orange Street 321, Big Village";

        textBoxPage.insertFullName(name);
        textBoxPage.insertEmail(email);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        Thread.sleep(1000);

        Assert.assertTrue(textBoxPage.emailField.getCssValue("border-color").equals("rgb(255, 0, 0)")
                            && textBoxPage.getTextOutput().equals(""));
    }

    @Test
    public void checkSubmit_FieldsArePopulatedExceptEmail(){
        String name = "Bob Adams";
        String email = "testmail@test.com";
        String currentAddress = "Banana Street 123, Big City";
        String permanentAddress = "Orange Street 321, Big Village";

        textBoxPage.insertFullName(name);
        textBoxPage.insertCurrentAddress(currentAddress);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        String outputText = textBoxPage.getTextOutput();

        Assert.assertTrue(outputText.contains(name)
                && !outputText.contains(email)
                && outputText.contains(currentAddress)
                && outputText.contains(permanentAddress)
        );
    }

    @Test
    public void checkSubmit_FieldsArePopulatedExceptCurrentAddress(){
        String name = "Bob Adams";
        String email = "testmail@test.com";
        String currentAddress = "Banana Street 123, Big City";
        String permanentAddress = "Orange Street 321, Big Village";

        textBoxPage.insertFullName(name);
        textBoxPage.insertEmail(email);
        textBoxPage.insertPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        String outputText = textBoxPage.getTextOutput();

        Assert.assertTrue(outputText.contains(name)
                && outputText.contains(email)
                && !outputText.contains(currentAddress)
                && outputText.contains(permanentAddress)
        );
    }

    @Test
    public void checkSubmit_NoFieldsArePopulated(){
        textBoxPage.clickOnSubmitButton();
        String outputText = textBoxPage.getTextOutput();
        Assert.assertTrue(outputText.equals(""));
    }
}
