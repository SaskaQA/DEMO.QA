package DemoQA.Tests.Forms;

import DemoQA.Base.Base;
import DemoQA.Pages.Forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends Base {

    public PracticeFormPage practiceFormPage;


    @BeforeMethod
    public void pageSetUp(){
        practiceFormURL = excelReader.getStringData("Forms", 0, 1);
        practiceFormPage = new PracticeFormPage();
        driver.get(practiceFormURL);
    }

    @Test
    public void checkOnlyOneRadioOptionCanActiveAtTime(){
        practiceFormPage.clickMaleRadioButton();
        practiceFormPage.clickFemaleRadioButton();
        practiceFormPage.clickOtherRadioButton();
        Assert.assertTrue(!practiceFormPage.maleRadioButton.isSelected() && !practiceFormPage.femaleRadioButton.isSelected() && practiceFormPage.otherRadioButton.isSelected());
    }

    @Test
    public void checkAllCheckBoxesCanBeSelected(){
        practiceFormPage.selectSports();
        practiceFormPage.selectReading();
        practiceFormPage.selectMusic();
        Assert.assertTrue(practiceFormPage.sportsBox.isSelected() && practiceFormPage.readingBox.isSelected() && practiceFormPage.musicBox.isSelected());
    }

    @Test
    public void pictureCanBeUploaded(){
        practiceFormPage.chooseFile(downloadFilePath + "pfp.jpg");
        //Ne znam assert
    }

    @Test void cityCanBeSelectedOnlyIfStateIs(){
        practiceFormPage.stateListSelectFirstOption();
    }
}
