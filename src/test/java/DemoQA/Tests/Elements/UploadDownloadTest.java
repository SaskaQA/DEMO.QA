package DemoQA.Tests.Elements;

import DemoQA.Base.Base;
import DemoQA.Pages.Elements.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class UploadDownloadTest extends Base {
    public UploadDownloadPage uploadDownloadPage;

    @BeforeMethod
    public void pageSetUp(){
        uploadAndDownloadURL = excelReader.getStringData("Elements", 7, 1);
        uploadDownloadPage = new UploadDownloadPage();
        driver.get(uploadAndDownloadURL);
    }

    @Test(priority = 1)
    public void userCanDownloadFile() throws InterruptedException {
        uploadDownloadPage.downloadFile();
        File file = new File(sampleImageFilePath);
        Thread.sleep(1000);
        Assert.assertTrue(file.exists());
    }

    @Test(priority = 2)
    public void userCanUploadFile(){
        uploadDownloadPage.uploadFile(sampleImageFilePath);
        Assert.assertEquals(uploadDownloadPage.uploadedFilePath.getText(), "C:\\fakepath\\sampleFile.jpeg");
    }
}
