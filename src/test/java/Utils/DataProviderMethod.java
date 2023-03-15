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
            obj = parser.parse(new FileReader("src/main/resources/testDataIncorrectInputs.json"));
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
        String nume, prenume, email, parola, confirmareParola, telefon, adresa, codPostal, judet, oras;

        JSONArray registerInfo = (JSONArray) jsonObject.get("register form InvalidData");
        String[] dataArray = new String[registerInfo.size()];

        for (int i = 0; i < registerInfo.size(); i++) {
            registerInfoData = (JSONObject) registerInfo.get(i);

            nume = (String) registerInfoData.get("numeField");
            prenume = (String) registerInfoData.get("prenumeField");
            email = (String) registerInfoData.get("emailField");
            parola = (String) registerInfoData.get("parolaField");
            confirmareParola = (String) registerInfoData.get("confirmareParolaField");
            telefon = (String) registerInfoData.get("telefonField");
            adresa = (String) registerInfoData.get("adresaField");
            codPostal = (String) registerInfoData.get("codPostalField");
            judet = (String) registerInfoData.get("judetSelect");
            oras = (String)registerInfoData.get("orasSelect");


            dataArray[i] = nume + "," + prenume + "," + email + "," + parola + "," + confirmareParola + "," + telefon + "," + adresa + "," + codPostal +
                    "," + judet + "," + oras;

        }
        return dataArray;
    }
    @DataProvider
    public Object[] dpRegValidInput() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("src/main/resources/testValidRegInputs.json"));
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
        String nume, prenume, email, parola, confirmareParola, telefon, adresa, codPostal, judet, oras;

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
            adresa = (String) registerInfoData.get("adresaField");
            codPostal = (String) registerInfoData.get("codPostalField");
            judet = (String) registerInfoData.get("judetSelect");
            oras = (String)registerInfoData.get("orasSelect");


            dataArray[i] = nume + "," + prenume + "," + email + "," + parola + "," + confirmareParola + "," + telefon + "," + adresa + "," + codPostal +
                    "," + judet + "," + oras;

        }
        return dataArray;
    }
}
