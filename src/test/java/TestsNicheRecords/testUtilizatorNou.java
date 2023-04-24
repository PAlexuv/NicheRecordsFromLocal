package TestsNicheRecords;

import Utils.DataProviderMethod;
import Utils.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.*;


public class testUtilizatorNou extends BaseTestsNR {

    @BeforeMethod
    public void goToRegister(){
        baseHeader.clickUtilizatorNou();
    }

    @Test(description = "Verify that user is not able to create an account using invalid inputs",
          dataProviderClass = DataProviderMethod.class, dataProvider = "dpRegInvalidInput")
    public void testInvalidData(String invalidData) {

        String[] regInvalidInput = invalidData.split(",");
        utilizatorNou.inputRegisterCredentials(regInvalidInput[0], regInvalidInput[1], regInvalidInput[2], regInvalidInput[3]
                , regInvalidInput[4], regInvalidInput[5], regInvalidInput[6], regInvalidInput[7], regInvalidInput[8], regInvalidInput[9]);

        String errorMessage = utilizatorNou.getErrorRegisterMessage();
        assertEquals(errorMessage, "Inregistrarea nu s-a procesat! Te rugam sa completezi toate campurile obligatorii.");
    }


    @Test(description = "Verify that user is able to create an account using valid inputs",
            dataProviderClass = DataProviderMethod.class, dataProvider = "dpRegValidInput")
    public void testValidData(String validData) {

        String[] regValidInput = validData.split(",");
        utilizatorNou.inputRegisterCredentials(regValidInput[0], regValidInput[1], regValidInput[2], regValidInput[3]
                , regValidInput[4], regValidInput[5], regValidInput[6], regValidInput[7], regValidInput[8], regValidInput[9]);

        String confirmRegistrationMessage = utilizatorNou.getConfirmRegisterMessage();
        assertEquals(confirmRegistrationMessage, "LOGOUT");
    }

    @Test(description = "test register judet localitate", dataProviderClass = DataProviderMethod.class, dataProvider = "dpRegJudetOrasEl")
    public void testJudetLocalitate(String validDataLoc) {
        String[] regValidInput = validDataLoc.split(",");
        utilizatorNou.inputRegisterJudetLocalitate(regValidInput[0], regValidInput[1]);
    }

}
