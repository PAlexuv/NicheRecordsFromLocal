package NicheRecords.PageObjects.headerNR;

import NicheRecords.PageObjects.BasePoPageNR;
import org.openqa.selenium.By;

public class utilizatorNouPo extends BasePoPageNR {

    private By headText = By.xpath("//h2[normalize-space()='Inregistrare']");

    private By nume = By.id("register_last_name");
    private By prenume = By.id("register_first_name");
    private By email = By.id("register_email_address");
    private By parola = By.id("register_password");
    private By confirmParola = By.id("register_password_confirmation");
    private By telefon = By.id("register_phone");

    private By judetSelect = By.id("register_address_state");
    private By orasSelect = By.id("register_address_city");

    private By adresa = By.id("register_address_address");
    private By codPostal = By.id("register_address_postal_code");
    private By checkboxAbonare = By.id("register_newsletter_subscribe");
    private By checkboxTermeni = By.id("register_toc");
    private By inregistrareButton = By.cssSelector("button[class='button-icon-reverse button-center']");
    private By confirmRegisterText = By.cssSelector("#menu [href='\\/logout\\.html']");//confirmation register page - page closes very fast -
    private By errorRegisterText = By.cssSelector(".form-has-error");

    public utilizatorNouPo inputRegisterCredentials(String numeText, String prenumeText, String emailText, String parolaText, String confirmParolaText,
                                                    String telefonText, String judet, String oras ,String adresaText, String codPostalText) {

        setText(nume, numeText);
        setText(prenume, prenumeText);
        setText(email, emailText);
        setText(parola, parolaText);
        setText(confirmParola, confirmParolaText);
        setText(telefon, telefonText);
        setText(adresa, adresaText);
        setText(codPostal, codPostalText);

//click
        clickElements(judet, oras);

        return this;
    }

    public utilizatorNouPo inputRegisterJudetLocalitate(String judet, String oras){
        clickElements(judet, oras);
        return this;
    }

    public utilizatorNouPo clickElements(String judet, String oras) {
        scrollElementIntoView(inregistrareButton);
        selectDropdownByVisibleText(judetSelect, judet);
        selectDropdownByVisibleText(orasSelect, oras);
        click(checkboxAbonare);
        click(checkboxTermeni);
        click(inregistrareButton);
        return this;
    }

    public String getConfirmRegisterMessage() {
        waitForElement(confirmRegisterText);
        System.out.println(getTextByText(confirmRegisterText));
        return getTextByText(confirmRegisterText);
    }

    public String getErrorRegisterMessage() {
        System.out.println(getTextByText(errorRegisterText));
        return getTextByText(errorRegisterText);
    }

    public String getHeadText() {
        System.out.println(getTextByText(headText));
        return driver.findElement(headText).getText();
    }
}
    //de vazut cum se poate face
//    public void assertIF() {
//        String errorRegistration = getErrorRegisterMessage();
//        String confirmRegistration = getConfirmRegisterMessage();
//
//        if (confirmRegistration.contains("LOGOUT")) {
//            assertEquals(confirmRegistration, "LOGOUT");
//        } else
//            errorRegistration.contains("Inregistrarea");
//            assertEquals(errorRegistration, "Inregistrarea nu s-a procesat!");
//    }


//    public utilizatorNouPo selectJudetOras(String judet, String oras) {
//        selectDropdownByValue(selectJudet, judet);
//        selectDropdownByValue(selectOras, oras);
//        return this;
//    }