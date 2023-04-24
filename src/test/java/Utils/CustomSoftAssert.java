package Utils;

import NicheRecords.PageObjects.BasePoPageNR;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;


public class CustomSoftAssert extends SoftAssert {

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError error) {
        String testName = assertCommand.getMessage();
        new BasePoPageNR().takeScreenshotNamed(testName);

    }


}
