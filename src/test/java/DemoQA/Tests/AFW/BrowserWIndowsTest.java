package DemoQA.Tests.AFW;

import DemoQA.Base.Base;
import DemoQA.Base.ExcelReader;
import DemoQA.Pages.AFW.BrowserWindowsPage;
import org.testng.annotations.BeforeMethod;

public class BrowserWIndowsTest extends Base {
    public BrowserWindowsPage browserWindowsPage;

    @BeforeMethod
    public void pageSetUp(){
        browserWindowsURL = excelReader.getStringData("AFW", 0, 1);
        browserWindowsPage = new BrowserWindowsPage();
        driver.get(browserWindowsURL);
    }


}
