package DemoQA.Pages.Elements;

import DemoQA.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDownloadPage extends Base {

    public UploadDownloadPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uploadFile")
    public WebElement upload;

    @FindBy(id = ("downloadButton"))
    public WebElement download;

    @FindBy(id = "uploadedFilePath")
    public WebElement uploadedFilePath;

    public void uploadFile(String filePath){
        upload.sendKeys(filePath);
    }
    public void downloadFile(){
        download.click();
    }
}
