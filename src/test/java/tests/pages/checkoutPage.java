package tests.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

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
    @FindBy(xpath = ".//*[@id='payment']/ul/li[3]/label")
    private WebElement checkboxPix;
    @FindBy(xpath = ".//button[@id='place_order']")
    private WebElement finallyButton;

    public static final String CLIENT_NAME = "Testando";
    public static final String CLIENT_LASTNAME = "da Silva";
    public static final String CLIENT_CPF = "096.592.464-55";
    public static final String CLIENT_CEP = "01001-000";
    public static final String CLIENT_ADDRESS = "Praça da Sé";
    public static final String CLIENT_ADDRESS_NUMBER = "10";
    public static final String CLIENT_CITY = "São Paulo";
    public static final String CLIENT_PHONE = "(83) 99303-5484";
    public String CLIENT_EMAIL = generateEmailAddress()+"@gmail.com";


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

        moveCursorToClick(fieldCEP);
        fillInField(fieldCEP, CLIENT_CEP);
        waitSeconds(3);
        scrollToElement(fieldNumber);

        moveCursorToClick(fieldAddress);
        fillInField(fieldAddress, CLIENT_ADDRESS);

        moveCursorToClick(fieldNumber);
        fillInField(fieldNumber, CLIENT_ADDRESS_NUMBER);

        moveCursorToClick(fieldCity);
        fillInField(fieldCity, CLIENT_CITY);

        moveCursorToClick(fieldPhone);
        fillInField(fieldPhone, CLIENT_PHONE);

        scrollToElement(fieldEmailAddress);

        moveCursorToClick(fieldEmailAddress);
        fillInField(fieldEmailAddress, CLIENT_EMAIL);

    }

    public void selectPaymentMethod() {
        scrollToElement(checkboxPix);
        waitSeconds(4);
        moveCursorToClick(checkboxPix);
        waitSeconds(15);
    }

    public void validateInformation(){
        waitSeconds(3);
        Assert.assertEquals(CLIENT_NAME, fieldName.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_LASTNAME, fieldLastname.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_CPF, fieldCPF.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_CEP, fieldCEP.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_ADDRESS, fieldAddress.getAttribute("value").toString());
        waitSeconds(3);
        Assert.assertEquals(CLIENT_ADDRESS_NUMBER, fieldNumber.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_CITY, fieldCity.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_PHONE, fieldPhone.getAttribute("value").toString());
        Assert.assertEquals(CLIENT_EMAIL, fieldEmailAddress.getAttribute("value").toString());
    }
    public confirmPage finallyOrder(){
        scrollToElement(finallyButton);
        waitSeconds(6);
        moveCursorToClick(finallyButton);
        waitTime(9000);

        return new confirmPage(driver);
    }

    private String generateEmailAddress(){
        String caracters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();

        Random rd = new Random();
        while (sb.length()< 10){
            int index = (int) (rd.nextFloat() * caracters.length());
            sb.append(caracters.charAt(index));
        }

        return sb.toString();
    }

}
