package TestsNicheRecords;

import Utils.CustomSoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSoftAssertUtilizatorNou extends BaseTestsNR{

    public static CustomSoftAssert softAssert = new CustomSoftAssert();

    @BeforeMethod
    public void goToRegister(){
        baseHeader.clickUtilizatorNou();
    }

    @Test
    public void testSoftAssert(){

        String pageTitle = getPageTitle();
        softAssert.assertEquals(pageTitle, "Magazin Muzica Online - pe CD, DVD, BLU-RAY, VINYL – NicheRecords.r", "pageTitle");

        String registrationHeadText = utilizatorNou.getHeadText();
        softAssert.assertEquals(registrationHeadText, "INREGISTRAR", "registrationHeadText");

        softAssert.assertAll();
    }
}
