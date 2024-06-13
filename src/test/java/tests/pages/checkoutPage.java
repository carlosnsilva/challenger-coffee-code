package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage extends basePage{

    @FindBy(xpath = ".//input[@id='billing_first_name']")
    private WebElement fieldName;
    @FindBy(xpath = ".//input[@id='billing_last_name']")
    private WebElement fieldLastname;
    @FindBy(xpath = ".//input[@id='billing_cpf']")
    private WebElement fieldCPF;
    @FindBy(xpath = ".//input[@id='billing_postcode']")
    private WebElement fieldCEP;
    @FindBy(xpath = ".//input[@id='billing_address_1']")
    private WebElement fieldAddress;
    @FindBy(xpath = ".//input[@id='billing_number']")
    private WebElement fieldNumber;
    @FindBy(xpath = ".//input[@id='billing_city']")
    private WebElement fieldCity;
    @FindBy(xpath = ".//input[@id='billing_phone']")
    private WebElement fieldPhone;
    @FindBy(xpath = ".//input[@id='billing_email']")
    private WebElement fieldEmailAddress;
    @FindBy(xpath = ".//input[@id='payment_method_getnet-pix']")
    private WebElement checkboxPix;
    @FindBy(xpath = ".//button[@id='place_order']")
    private WebElement finallyButton;

    public static final String CLIENT_NAME = "Testando";
    public static final String CLIENT_LASTNAME = "da Silva";
    public static final String CLIENT_CPF = "00000000000";
    public static final String CLIENT_CEP = "01001000";
    public static final String CLIENT_ADDRESS = "Praça da Sé";
    public static final String CLIENT_ADDRESS_NUMBER = "10";
    public static final String CLIENT_CITY = "São Paulo";
    public static final String CLIENT_PHONE = "83993035484";
    public static final String CLIENT_EMAIL = "cmanoel17@gmail.com";


    public checkoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void completeForm(){
        scrollToElement(fieldCEP);

        moveCursorToClick(fieldName);
        fillInField(fieldName, CLIENT_NAME);

        moveCursorToClick(fieldLastname);
        fillInField(fieldLastname, CLIENT_LASTNAME);

        moveCursorToClick(fieldCPF);
        fillInField(fieldCPF, CLIENT_CPF);

        moveCursorToClick(checkboxPix);

        moveCursorToClick(fieldCEP);
        fillInField(fieldCEP, CLIENT_CEP);

        scrollToElement(fieldNumber);

        moveCursorToClick(fieldAddress);
        fillInField(fieldAddress, CLIENT_ADDRESS);

        moveCursorToClick(fieldNumber);
        fillInField(fieldNumber, CLIENT_ADDRESS_NUMBER);

        moveCursorToClick(fieldCity);
        fillInField(fieldCity, CLIENT_CITY);

        moveCursorToClick(fieldPhone);
        fillInField(fieldPhone, CLIENT_PHONE);

        moveCursorToClick(fieldEmailAddress);
        fillInField(fieldEmailAddress, CLIENT_EMAIL);

    }

    public void selectPaymentMethod() {
        moveCursorToClick(checkboxPix);
    }

    public void validateInformation(){
        System.out.println("Validando as informações antes de finalizar o pedido");
        Assert.assertEquals(CLIENT_NAME, fieldName.getText().toString());
        Assert.assertEquals(CLIENT_LASTNAME, fieldLastname.getText().toString());
        Assert.assertEquals(CLIENT_CPF, fieldCPF.getText().toString());
        Assert.assertEquals(CLIENT_CEP, fieldCEP.getText().toString());
        Assert.assertEquals(CLIENT_ADDRESS, fieldAddress.getText().toString());
        Assert.assertEquals(CLIENT_ADDRESS_NUMBER, fieldAddress.getText().toString());
        Assert.assertEquals(CLIENT_CITY, fieldCity.getText().toString());
        Assert.assertEquals(CLIENT_PHONE, fieldPhone.getText().toString());
        Assert.assertEquals(CLIENT_EMAIL, fieldEmailAddress.getText().toString());
    }
    public confirmPage finallyOrder(){
        moveCursorToClick(finallyButton);

        return new confirmPage(driver);
    }


}
