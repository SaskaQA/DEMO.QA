package DemoQA.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public WebDriverWait wait;
    public ExcelReader excelReader;
    public String textBoxURL, radioButtonURL, checkBoxURL, webTablesURL, buttonsURL, linksURL, brokenLinksURL, uploadAndDownloadURL, dynamicPropertiesURL;
    public String practiceFormURL;
    public String browserWindowsURL, alertsURL, framesURL, nestedFramesURL, modalDialogsURL;
    public static String downloadFilePath = System.getProperty("user.home") + "\\Downloads\\";
    public static String sampleImageFilePath = downloadFilePath + "sampleFile.jpeg";


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        driver.manage().window().maximize();
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @AfterClass
    public void tearDown() {
        File file = new File(sampleImageFilePath);
        if(file.exists())
            file.delete();
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
