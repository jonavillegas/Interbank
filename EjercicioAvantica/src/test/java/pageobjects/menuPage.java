package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class menuPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Generate Card Number") private WebElement linkGenerarTarjeta;


    public menuPage(WebDriver dvr) {
        driver = dvr;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void clickGenerarTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(linkGenerarTarjeta));
        linkGenerarTarjeta.click();
    }




}
