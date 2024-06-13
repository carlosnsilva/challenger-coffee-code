package tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends basePage{

    @FindBy(xpath = ".//input[@id='woocommerce-product-search-field-0']")
    private WebElement searchBar;

    @FindBy(xpath = ".//*[@id='main']/ul/li[3]/a[2]")
    private WebElement buttonBuy;

    @FindBy(xpath = ".//*[text()='Ver carrinho']")
    private WebElement viewCarButton;

    public static final String HOODIE_PRODUCT = "Hoodie";

    public static final String URL_HOMEPAGE ="https://challenge.homolog.tech/";
    public homePage(){
        super(null);
        PageFactory.initElements(driver,this);
        start(URL_HOMEPAGE);
    }

    public homePage searchProduct(){
        moveCursorToClick(searchBar);
        fillInField(searchBar, HOODIE_PRODUCT);
        pressEnter(searchBar);

        return new homePage();
    }

    public cartPage selectProduct(){
        moveCursorToClick(buttonBuy);
        moveCursorToClick(viewCarButton);

        return new cartPage();
    }


}
