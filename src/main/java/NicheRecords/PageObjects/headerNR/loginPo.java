package NicheRecords.PageObjects.headerNR;

import NicheRecords.PageObjects.BasePoPageNR;
import org.openqa.selenium.By;

public class loginPo extends BasePoPageNR {
    private By username = By.cssSelector("#signin_username");
    private By password = By.cssSelector("#signin_password");
    private By buttonLogin = By.cssSelector("button[class='button-icon-reverse']");
    private By confirmLoggedIn = By.xpath("//ul[@class='account']//a[normalize-space()='Logout']");

    public loginPo inputValidLogin(String usernameText, String passwordText){
        setText(username, usernameText);
        setText(password, passwordText);
        click(buttonLogin);
        return this;
    }
    public String getConfirmationLogin(){
        waitForElement(confirmLoggedIn);
        System.out.println("Confirmation message for succes login: " + getTextByText(confirmLoggedIn));
        return getTextByText(confirmLoggedIn);
    }

}
