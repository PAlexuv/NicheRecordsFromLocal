package TestsNicheRecords;

import NicheRecords.PageObjects.BasePoPageNR;
import NicheRecords.PageObjects.headerNR.baseHeader.baseHeaderNR;
import NicheRecords.PageObjects.headerNR.*;
import Utils.TestListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


@Listeners(TestListener.class)
public class BaseTestsNR extends BasePoPageNR {

    //Header
    protected baseHeaderNR baseHeader;
    protected utilizatorNouPo utilizatorNou;
    protected loginPo login;
    protected contulMeuPo contulMeu;
    protected catalogPo catalog;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Assert.assertTrue(goToHomepageNR(), "Unable to navigate to homepage!");
    //Header
        baseHeader = new baseHeaderNR();
        utilizatorNou = new utilizatorNouPo();
        login = new loginPo();
        contulMeu = new contulMeuPo();
        catalog = new catalogPo();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        closeBrowser();
    }

}
