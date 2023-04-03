package Utils;

import TestsNicheRecords.BaseTestsNR;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataProviderMethod extends BaseTestsNR {

    @DataProvider
    public Object[] dpRegInvalidInput() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/testIncorrectRegInputs.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
        assert jsonObject != null;

        JSONObject registerInfoData;
        String nume, prenume, email, parola, confirmareParola, telefon, judet, oras, adresa, codPostal;

        JSONArray registerInfo = (JSONArray) jsonObject.get("register_Form_InvalidData");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            nume = (String) registerInfoData.get("numeField");
            prenume = (String) registerInfoData.get("prenumeField");
            email = (String) registerInfoData.get("emailField");
            parola = (String) registerInfoData.get("parolaField");
            confirmareParola = (String) registerInfoData.get("confirmareParolaField");
            telefon = (String) registerInfoData.get("telefonField");
            judet = (String) registerInfoData.get("judetSelect");
            oras = (String)registerInfoData.get("orasSelect");
            adresa = (String) registerInfoData.get("adresaField");
            codPostal = (String) registerInfoData.get("codPostalField");


            dataArray[i] = nume + "," + prenume + "," + email + "," + parola + "," + confirmareParola + "," + telefon + "," + judet + "," + oras + "," + adresa + "," + codPostal;

        }
        return dataArray;
    }
    @DataProvider
    public Object[] dpRegValidInput() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/validRegInputs.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
        assert jsonObject != null;

        JSONObject registerInfoData;
        String nume, prenume, email, parola, confirmareParola, telefon, judet, oras, adresa, codPostal;

        JSONArray registerInfo = (JSONArray) jsonObject.get("registerValidData");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            nume = (String) registerInfoData.get("numeField");
            prenume = (String) registerInfoData.get("prenumeField");
            email = (String) registerInfoData.get("emailField");
            parola = (String) registerInfoData.get("parolaField");
            confirmareParola = (String) registerInfoData.get("confirmareParolaField");
            telefon = (String) registerInfoData.get("telefonField");
            judet = (String) registerInfoData.get("judetSelect");
            oras = (String)registerInfoData.get("orasSelect");
            adresa = (String) registerInfoData.get("adresaField");
            codPostal = (String) registerInfoData.get("codPostalField");
            dataArray[i] = nume + "," + prenume + "," + email + "," + parola + "," + confirmareParola + "," + telefon + "," + judet + "," + oras + "," +
                    adresa + "," + codPostal;

        }
        return dataArray;
    }

    @DataProvider
    public Object[] dpRegJudetOrasEl() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/dropdownRegisterEl.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
        assert jsonObject != null;

        JSONObject registerInfoData;
        String judet, oras;

        JSONArray registerInfo = (JSONArray) jsonObject.get("registerDropdownEl");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            judet = (String) registerInfoData.get("judetSelect");
            oras = (String) registerInfoData.get("orasSelect");

            dataArray[i] = judet + "," + oras;

        }
        return dataArray;
    }

    @DataProvider
    public Object[] dpValidLogin() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/validLogin.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
        assert jsonObject != null;

        JSONObject registerInfoData;
        String usernameLogin, passwordLogin;

        JSONArray registerInfo = (JSONArray) jsonObject.get("validLogin");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            usernameLogin = (String) registerInfoData.get("usernameLogin");
            passwordLogin = (String) registerInfoData.get("passwordLogin");

            dataArray[i] = usernameLogin + "," + passwordLogin;

        }
        return dataArray;
    }

    @DataProvider
    public Object[] dpValidChangePass() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/validChangedPass.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj;
        assert jsonObject != null;

        JSONObject registerInfoData;
        String parolaCurenta, parolaNoua, confirmareParolaNoua;

        JSONArray registerInfo = (JSONArray) jsonObject.get("validChangePassword");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            parolaCurenta = (String) registerInfoData.get("parolaCurenta");
            parolaNoua = (String) registerInfoData.get("parolaNoua");
            confirmareParolaNoua = (String) registerInfoData.get("confirmareParolaNoua");

            dataArray[i] = parolaCurenta + "," + parolaNoua + "," + confirmareParolaNoua ;

        }
        return dataArray;
    }
}
