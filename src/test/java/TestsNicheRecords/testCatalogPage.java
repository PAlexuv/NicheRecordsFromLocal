package TestsNicheRecords;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class testCatalogPage extends BaseTestsNR{
    @BeforeMethod(description = "open catalog page, click on catalog button and ")
    public void openCatalog(){
        baseHeader.clickCatalog();
    }

    @Test(description = "check if catalog page opens")
    public void testCatalogPage(){
       String confirmCatalogOpened = catalog.confirmCatalogPageOpened();
       assertEquals(confirmCatalogOpened, "CATALOG");
    }

    @Test(description = "Verify that user is able to add an item to bag")
    public void testAddItem(){
        catalog.addItemToCart();
        String confirmAddedItem = catalog.confirmAdditem();
        assertEquals(confirmAddedItem, "ariei de acoperire a FAN Courier");
    }

    @Test(description = "[Actualizare cos] Verify that user is able to update item quantity using valid input")
    public void testUpdateCartItems(){
    catalog.addItemToCart();
    catalog.updateCartItems("3");
    String confirmCartUpdate =  catalog.confirmCartUpdate();
    assertEquals(confirmCartUpdate, "3");
    }

    @Test(description = "[Sterge din cos] Verify that user is able to remove an item from cart")
    public void testDeleteCartItem(){
        catalog.addItemToCart();
        catalog.deleteCartItems();
        String confirmDeletedItem = catalog.confirmDeleteCartItem();
        assertEquals(confirmDeletedItem, "Cosul tau de cumparaturi este gol.");
    }

}
