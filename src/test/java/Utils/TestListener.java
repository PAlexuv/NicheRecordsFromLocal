package Utils;

import NicheRecords.PageObjects.BasePoPageNR;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener extends BasePoPageNR implements ITestListener {
    private static ExtentReports extentReports = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("ExtentReport.html");

    @Override
    public void onTestFailure(ITestResult result) {

        String failedTest = result.getName();
        takeScreenshotNamed(failedTest);
        log.error("Test " + failedTest + " has failed.. take screenshot");

        //-------------- EXTENT REPORTS with SCREENSHOT -----------------
        //Create the screenshot name to match the name given in the BasePo to be able to read the picture's correct name

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss");
        LocalDateTime currentTime = LocalDateTime.now();

        String dateTimeFormatted = currentTime.format(formatter);
        String screenshotName = "\\TestName_" + failedTest + "_" + dateTimeFormatted + ".jpeg"; //here we set the path inside the folder ScreenshotsNR

        String screenshotsDir = "./ScreenshotsNR";// i cannot use SCREENSHOT_PATH as it is blocked for access so i must create the string

        extentReports.attachReporter(reporter);
        extentReports.createTest(failedTest)
                .log(Status.FAIL, failedTest + " - failure")
                .addScreenCaptureFromPath(screenshotsDir + screenshotName);
//                .fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotsDir + screenshotName).build()); in caz ca nu merge cea de sus
        extentReports.flush();
        //-----------------------------------------------
    }

}
