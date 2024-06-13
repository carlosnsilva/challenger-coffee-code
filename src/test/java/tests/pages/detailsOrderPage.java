package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class detailsOrderPage extends basePage{

    @FindBy(xpath = ".//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    private WebElement orderButton;

    @FindBy(xpath = ".//a[@class='woocommerce-button button view']")
    private WebElement viewOrderButton;

    @FindBy(xpath = ".//a[text()='Hoodie with Logo']")
    private WebElement fieldDescriptionProduct;

    @FindBy(xpath = ".//td[text()='Getnet PIX']")
    private WebElement fieldMethodPayment;

    public static final String PRODUCT_NAME = "Hoodie with Logo";
    public static final String METHOD_PAYMENT = "Getnet PIX";


    public detailsOrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void viewDetailsOrder(){
        moveCursorToClick(orderButton);
        moveCursorToClick(viewOrderButton);
        Assert.assertEquals(PRODUCT_NAME, fieldDescriptionProduct.getText().toString());
        Assert.assertEquals(METHOD_PAYMENT, fieldMethodPayment.getText().toString());

        close();
    }


}
