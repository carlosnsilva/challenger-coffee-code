package tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homePage extends basePage{

    public static final String URL_HOMEPAGE ="https://challenge.homolog.tech/";
    public homePage(){
        super(null);
        PageFactory.initElements(driver,this);
        start(URL_HOMEPAGE);
    }


}
