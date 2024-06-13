package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmPage extends basePage{

    @FindBy(xpath = ".//strong[text()='cmanoel17@gmail.com']")
    private WebElement fieldEmailAddress;
    @FindBy(xpath = ".//*[@id='post-8']/div/div/div/ul/li[4]/strong/span/bdi/span")
    private WebElement fieldTotalPrice;
    @FindBy(xpath = ".//strong[text()='Getnet PIX']")
    private WebElement fieldMethodPayment;
    @FindBy(xpath = ".//a[text()='Hoodie with Logo']")
    private WebElement fieldDescriptionProduct;
    @FindBy(xpath = ".//*[@id='post-8']/div/div/div/section[2]/section/div[2]/address")
    private WebElement fieldDescriptonAddress;

    @FindBy(xpath = ".//li[@class='page_item page-item-9 focus']/a")
    private WebElement myAccountButton;

    public static final String CLIENT_EMAIL = "cmanoel17@gmail.com";
    public static final String TOTAL_ORDER = "45,00";
    public static final String CLIENT_CEP = "01001000";
    public static final String CLIENT_ADDRESS = "Praça da Sé";
    public static final String CLIENT_ADDRESS_NUMBER = "10";
    public static final String CLIENT_CITY = "São Paulo";
    public static final String DESCRIPTION_PRODUCT = "Hoodie with Logo";

    public confirmPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public detailsOrderPage validateOrder(){
        Assert.assertEquals(CLIENT_EMAIL, fieldEmailAddress.getText().toString());
        Assert.assertEquals(TOTAL_ORDER, fieldTotalPrice.getText().toString());
        Assert.assertEquals(DESCRIPTION_PRODUCT, fieldDescriptionProduct.getText().toString());
        System.out.println("ENDEREÇO: "+fieldDescriptionProduct.getText().toString());
        //Assert.assertEquals();
        //Assert.assertEquals();

        moveCursorToClick(myAccountButton);

        return new detailsOrderPage(driver);
    }


}
