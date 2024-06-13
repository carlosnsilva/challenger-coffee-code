package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage extends basePage{

    @FindBy(xpath = ".//td[@class='product-name']/a[text()='Hoodie with Logo']")
    private WebElement nameProduct;

    @FindBy(xpath = ".//td[@class='product-price']/span/bdi/span")
    private WebElement priceProduct;

    @FindBy(xpath = ".//div[@class='wc-proceed-to-checkout']/a")
    private WebElement continueBuyButton;

    public static final String PRODUCT_NAME = "Hoodie with Logo";
    public static final String PRODUCT_PRICE = "45,00";

    public cartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public checkoutPage reviewCart(){
        Assert.assertEquals(PRODUCT_NAME, nameProduct.getText().toString());
        Assert.assertEquals(PRODUCT_PRICE, priceProduct.getText().toString());
        waitSeconds(2);
        scrollToElement(continueBuyButton);
        moveCursorToClick(continueBuyButton);

        return new checkoutPage(driver);
    }


}
