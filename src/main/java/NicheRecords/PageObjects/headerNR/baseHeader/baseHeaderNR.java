package NicheRecords.PageObjects.headerNR.baseHeader;

import NicheRecords.PageObjects.BasePoPageNR;
import NicheRecords.PageObjects.headerNR.*;
import org.openqa.selenium.By;

public class baseHeaderNR extends BasePoPageNR {

    //  Header
    private By acasaButton = By.xpath("//div[@class='container']//a[normalize-space()='Acasa']");
    private By catalogButton = By.xpath("//div[@class='container']//a[normalize-space()='Catalog']");
    private By artistiButton = By.xpath("//div[@class='container']//a[normalize-space()='Artisti']");
    private By contactButton = By.xpath("//div[@class='container']//nav//a[normalize-space()='Contact']");
    private By loginButton = By.xpath("//ul[@class='account']//a[normalize-space()='Login']");
    private By utilizatorNouButton = By.xpath("//ul[@class='account']//a[normalize-space()='Utilizator nou']");
    private By contulMeuButton = By.xpath("//ul[@class='account']//a[normalize-space()='Contul meu']");
    private By cosulTauButton = By.cssSelector("div[class='cart'] a");
    private By wishlistButton = By.xpath("//span[normalize-space()='Wishlist']");

    public acasaPo clickAcasa() {
        click(acasaButton);
        return new acasaPo();
    }

    public artistiPo clickArtisti() {
        click(artistiButton);
        return new artistiPo();
    }

    public catalogPo clickCatalog(){
        click(catalogButton);
        return new catalogPo();
    }

    public contactPo clickContact(){
        click(contactButton);
        return new contactPo();
    }

    public loginPo clickLogin(){
        click(loginButton);
        return new loginPo();
    }

    public utilizatorNouPo clickUtilizatorNou(){
        waitForElement(utilizatorNouButton);
        click(utilizatorNouButton);
        return new utilizatorNouPo();
    }

    public contulMeuPo clickContulMeu(){
        click(contulMeuButton);
        return new contulMeuPo();
    }

    public cosulTauPo clickCosulTau(){
        click(cosulTauButton);
        return new cosulTauPo();
    }

    public wishlistPo clickWishlist(){
        click(wishlistButton);
        return new wishlistPo();
    }


}
