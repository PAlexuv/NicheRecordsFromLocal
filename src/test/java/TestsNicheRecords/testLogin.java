package TestsNicheRecords;

import Utils.DataProviderMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class testLogin extends BaseTestsNR {

    @BeforeMethod(description = "go to login")
    public void goToLogin(){
        baseHeader.clickLogin();
    }

    @Test(description = "verify user can login with valid registered credentials",
            dataProviderClass = DataProviderMethod.class, dataProvider = "dpValidLogin")
    public void testValidLogin(String validData) {

        String[] loginValidData = validData.split(",");
        login.inputValidLogin(loginValidData[0],loginValidData[1]);

        String successLogin = login.getConfirmationLogin();
        assertEquals(successLogin, "LOGOUT");
    }
}
