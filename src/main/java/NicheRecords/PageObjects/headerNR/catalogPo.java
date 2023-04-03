package NicheRecords.PageObjects.headerNR;

import NicheRecords.PageObjects.BasePoPageNR;
import org.openqa.selenium.By;

public class catalogPo extends BasePoPageNR {
    private By catalogHeaderText = By.xpath("//h1[normalize-space()='Catalog']");
    private By addFirstItem = By.cssSelector("form[class='add-to-cart-form add_product_cos product_id_535022'] span[class='text']");
    private By confirmAddedItemToCart = By.xpath("//a[normalize-space()='ariei de acoperire a FAN Courier']");
    private By confirmCartHasItems = By.xpath("//span[@class='text number']");
    private By cartButton = By.cssSelector("div[class='cart']");
    private By cartUpdateField = By.xpath("//input[@name='cart_item_qty[]']");
    private By cartDeleteItemsButton = By.xpath("//a[@onclick=\"return confirm('Esti sigur ?');\"]");
    private By confirmDeleteCartItem = By.xpath("//h3[normalize-space()='Cosul tau de cumparaturi este gol.']");

    public String confirmCatalogPageOpened() {
        System.out.println("Opened page: " + getTextByText(catalogHeaderText));
        return getTextByText(catalogHeaderText);
    }

    //add Item to cart
    public catalogPo addItemToCart() {
        click(addFirstItem);
        return this;
    }

    public String confirmAdditem() {
        System.out.println("text to confirm added item: " + getTextByText(confirmAddedItemToCart));
        return getTextByText(confirmAddedItemToCart);
    }

    //update cart
    public catalogPo updateCartItems(String value) {
        System.out.println(getTextByText(confirmCartHasItems));
        click(cartButton);
        setText(cartUpdateField, value);
        return this;
    }
    public String confirmCartUpdate() {
        System.out.println("Confirm that cart has been updated to: " + getTextByValue(cartUpdateField));
        String textValueOfCartItems = getTextByValue(cartUpdateField);
        System.out.println(textValueOfCartItems);
        return textValueOfCartItems;
    }

    //clear basket
    public catalogPo deleteCartItems() {
        click(cartButton);
        click(cartDeleteItemsButton);
        acceptPopup();
        return this;
    }

    public String confirmDeleteCartItem() {
        System.out.println("Texto to confirm deleted item: " + getTextByText(confirmDeleteCartItem));
        return getTextByText(confirmDeleteCartItem);
    }


}
