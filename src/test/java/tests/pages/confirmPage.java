package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmPage extends basePage{

    @FindBy(xpath = ".//div[@class='woocommerce-order']/p")
    private WebElement successMensage;
    @FindBy(xpath = ".//li[@class='woocommerce-order-overview__email email']/strong")
    private WebElement fieldEmailAddress;
    @FindBy(xpath = ".//*[@id='post-8']/div/div/div/ul/li[4]/strong/span/bdi/span")
    private WebElement fieldTotalPrice;
    @FindBy(xpath = ".//strong[text()='Getnet PIX']")
    private WebElement fieldMethodPayment;
    @FindBy(xpath = ".//a[text()='Hoodie with Logo']")
    private WebElement fieldDescriptionProduct;
    @FindBy(xpath = ".//*[@id='post-8']/div/div/div/section[2]/section/div[2]/address")
    private WebElement fieldDescriptonAddress;
    @FindBy(xpath = "//*[@id='page']/div[1]/div/nav/a[1]")
    private WebElement startLink;
    @FindBy(xpath = "/html/body/div/header/div[2]/div/nav/div[1]/ul/li[4]/a")
    private WebElement myAccountButton;

    public static final String CLIENT_NAME = "Testando";
    public static final String CLIENT_LASTNAME = "da Silva";
    public static final String CLIENT_ADDRESS = "Praça da Sé";
    public static final String CLIENT_ADDRESS_NUMBER = "10";
    public static final String CLIENT_CITY = "São Paulo";
    public static final String DESCRIPTION_PRODUCT = "Hoodie with Logo";
    public static final String CLIENT_CEP = "01001-000";
    public static final String CLIENT_STATE = "Minas Gerais";
    public static final String SUCCESS_MENSAGE = "Obrigado. Seu pedido foi recebido.";

    public confirmPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public detailsOrderPage validateOrder(){
        waitTime(5000);
        Assert.assertEquals(SUCCESS_MENSAGE, successMensage.getText().toString());
        Assert.assertNotNull(fieldEmailAddress.getText().toString());
        Assert.assertEquals(DESCRIPTION_PRODUCT, fieldDescriptionProduct.getText().toString());
        Assert.assertEquals(CLIENT_NAME+" "+CLIENT_LASTNAME+"\n"+CLIENT_ADDRESS+", "+CLIENT_ADDRESS_NUMBER+"\n"+CLIENT_CITY+"\n"+CLIENT_STATE+"\n"+CLIENT_CEP, fieldDescriptonAddress.getText().toString());

        waitTime(6000);
        moveCursorToClick(startLink);
        waitTime(3000);
        moveCursorToClick(myAccountButton);

        return new detailsOrderPage(driver);
    }


}
