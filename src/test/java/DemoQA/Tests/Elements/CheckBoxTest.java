package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.CheckBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends Base {
    public CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetUp(){
        checkBoxURL = excelReader.getStringData("Elements", 1, 1);
        checkBoxPage = new CheckBoxPage();
        driver.get(checkBoxURL);
    }

    //user can view all check boxes (by clicking on arrows one by one)

    //user can select all check boxes

    //user can unselect all check boxes

    //user can select one check box

    //user can unselect one check box
}
