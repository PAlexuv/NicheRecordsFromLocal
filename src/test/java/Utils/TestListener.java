package Utils;

import NicheRecords.PageObjects.BasePoPageNR;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class TestListener extends BasePoPageNR implements ITestListener {
    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

    @Override
    public void onTestFailure(ITestResult result) {
        String failedTest = result.getName();
        log.error("Test" + failedTest + " has failed.. take screenshot");
        takeScreenshotNamed(failedTest);

        //**************************

        //-------------- EXTENT REPORTS with SCREENSHOT -----------------
        //Create the screenshot name to match the name given in the BasePo to be able to read the picture's correct name
        LocalDateTime currentTime = LocalDateTime.now();
        String dateTimeFormat = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "-");
        String screenshotName = "\\Screenshot-" + failedTest + "-" + dateTimeFormat + ".jpeg";

        String screenshotsDir = "./ScreenshotsNR/";

        extentReports.attachReporter(reporter);
        extentReports.createTest(failedTest)
                .log(Status.FAIL, failedTest+ " - failure")
                .addScreenCaptureFromPath(screenshotsDir + screenshotName);
//                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsDir + screenshotName).build()); in caz ca nu merge cea de sus
        extentReports.flush();
        //-----------------------------------------------
    }
}
