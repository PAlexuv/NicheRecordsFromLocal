package Utils;

import NicheRecords.PageObjects.BasePoPageNR;
import lombok.SneakyThrows;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;


public class CustomSoftAssert extends SoftAssert {

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError error) {
        String testName = assertCommand.getMessage();
        new BasePoPageNR().takeScreenshotNamed(testName);

    }


}
