package TestsNicheRecords;

import Utils.DataProviderMethod;
import Utils.TestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

@Listeners(TestListener.class)
public class testContulMeu extends BaseTestsNR {

    @BeforeMethod(description = "go to login")
    public void goToLogin(){
        baseHeader.clickLogin();
        login.loginCredentials();
    }

    @Test(description = "verify user can change the password", dataProviderClass = DataProviderMethod.class, dataProvider = "dpValidChangePass", priority = 1)
    public void changePasswordContulMeu(String validData) {

        String[] changePassValidData = validData.split(",");

        contulMeu.changePasswordValid(changePassValidData[0], changePassValidData[1], changePassValidData[2]);
        String confirmationMessage = contulMeu.confirmPassChanged();
        assertEquals(confirmationMessage, "(*) Parola noua trebuie sa aiba minim 6 caractere");
    }


}

