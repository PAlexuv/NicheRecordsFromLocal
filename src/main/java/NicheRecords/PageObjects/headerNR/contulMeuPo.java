package NicheRecords.PageObjects.headerNR;

import NicheRecords.PageObjects.BasePoPageNR;
import org.openqa.selenium.By;

public class contulMeuPo extends BasePoPageNR {

    //schimbare parola
    private By contulMeuButton = By.cssSelector("ul[class='account'] li:nth-child(2) a:nth-child(1)");
    private By schimbareParolaButton = By.cssSelector("a[href='/cont/parola.html']");
    private By parolaCurentaField = By.cssSelector("input[name='pass[old]']");
    private By parolaNouaField = By.cssSelector("input[name='pass[new]']");
    private By confirmareParolaField = By.cssSelector("input[name='pass[new_conf]']");
    private By saveNewPassButton = By.cssSelector("button[type='submit'] span[class='text']");
    private By confirmationMessage = By.cssSelector("div[class='form-group'] center p");
    //************

    public contulMeuPo inputValidChangePass(String parolaCurentaText, String parolaNouaText, String confirmareParolaText){
        waitForElement(contulMeuButton);
        click(contulMeuButton);
        waitForElement(schimbareParolaButton);
        click(schimbareParolaButton);
        waitForElement(parolaCurentaField);
        setText(parolaCurentaField, parolaCurentaText);
        setText(parolaNouaField, parolaNouaText);
        setText(confirmareParolaField, confirmareParolaText);
        click(saveNewPassButton);
        return this;
    }
    public String confirmPassChanged(){
        System.out.println("unchanged somewhat confirmation message:" + getTextByText(confirmationMessage));
        return getTextByText(confirmationMessage);
    }
}
