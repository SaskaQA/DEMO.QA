package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends Base {
    public WebTablesPage webTablesPage;

    @BeforeMethod
    public void pageSetUp(){
        webTablesURL = excelReader.getStringData("Elements", 3, 1);
        webTablesPage = new WebTablesPage();
        driver.get(webTablesURL);
    }

    @Test
    public void userCanAddNewRecord(){
        String firstName = "Keanu";
        String lastName = "Reeves";
        String email = "keanurr@gmail.com";
        String age = "58";
        String salary = "15000";
        String department = "movie";

        webTablesPage.addNewRecord(firstName, lastName, email, age, salary, department);
        String newlyAddedRecord = webTablesPage.fourthTableRecord.getText();
        Assert.assertTrue(newlyAddedRecord.contains(firstName)
                                && newlyAddedRecord.contains(lastName)
                                && newlyAddedRecord.contains(email)
                                && newlyAddedRecord.contains(age)
                                && newlyAddedRecord.contains(salary)
                                && newlyAddedRecord.contains(department));
    }

    @Test
    public void userCanEditRecord(){
        String lastName = "Peric";
        String age = "55";
        String salary = "7770";

        webTablesPage.editRecord(1,null, lastName, null, age, salary, null);
        String editedRecord = webTablesPage.firstTableRecord.getText();
        Assert.assertTrue(editedRecord.contains(lastName)
                && editedRecord.contains(age)
                && editedRecord.contains(salary));
    }

    @Test
    public void userCanDeleteRecord(){
        String firstRecord = webTablesPage.firstTableRecord.getText();
        webTablesPage.deleteRecord(1);
        Assert.assertNotEquals(webTablesPage.firstTableRecord.getText(), firstRecord);
    }

    @Test
    public void userCanSearchForRecord(){
        String searchName = "Kierra";
        webTablesPage.searchForRecord(searchName);
        Assert.assertTrue(webTablesPage.firstTableRecord.getText().contains(searchName));
    }
}
