package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pagoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(tagName = "h2") private WebElement labelTitulo;
    @FindBy(id = "card_nmuber") private WebElement txtTarjeta;
    @FindBy(id = "month") private WebElement comboMes;
    @FindBy(id = "year") private WebElement comboAnio;
    @FindBy(id = "cvv_code") private WebElement txtcvv;
    @FindBy(name = "submit") private WebElement buttonPagar;

    public pagoPage(WebDriver dvr){
        driver = dvr;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void validarTitulo(){
        wait.until(ExpectedConditions.visibilityOf(labelTitulo));
        Assert.assertTrue(labelTitulo.isDisplayed());
        Assert.assertEquals("Payment Process",labelTitulo.getText());
    }

    public void escribirTarjeta(String texto){
        txtTarjeta.sendKeys(texto);
    }

    public void seleccionarMes(String mes){
        new Select(comboMes).selectByVisibleText(mes);
    }

    public void seleccionarAnio(String anio){
        new Select(comboAnio).selectByValue(anio);
    }


    public void escribirCvv(String cvv) {
        txtcvv.sendKeys(cvv);
    }

    public void clickPagar() {
        buttonPagar.click();
    }
}
