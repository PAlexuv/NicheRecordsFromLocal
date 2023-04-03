package TestsNicheRecords;

import Utils.DataProviderMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class testChangePassword extends BaseTestsNR {


    @BeforeMethod(description = "go to login")
    public void goToLogin(){
        baseHeader.clickLogin();
        login.loginCredentials();
    }

    @Test(description = "verify user can change the password", dataProviderClass = DataProviderMethod.class, dataProvider = "dpValidChangePass", priority = 1)
    public void changePasswordContulMeu(String validData) {

        String[] changePassValidData = validData.split(",");

        contulMeu.inputValidChangePass(changePassValidData[0], changePassValidData[1], changePassValidData[2]);
        String confirmationMessage = contulMeu.confirmPassChanged();
        assertEquals(confirmationMessage, "(*) Parola noua trebuie sa aiba minim 6 caractere.");
    }


}

