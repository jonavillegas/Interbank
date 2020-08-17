package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class tarjetaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public static String tarjeta;
    public static String cvv;
    public static String mes;
    public static String anio;


    @FindBy(xpath = "//h4[contains(text(),'Card Number')]") private WebElement labelTarjeta;
    @FindBy(xpath = "//h4[contains(text(),'CVV')]") private WebElement labelCVV;
    @FindBy(xpath = "//h4[contains(text(),'Exp')]") private WebElement labelFecha;

    public tarjetaPage(WebDriver dvr) {
        driver=dvr;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void obtenerTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(labelTarjeta));
        tarjeta= labelTarjeta.getText().replace("Card Number:- ","");
        System.out.println(tarjeta);
    }
    public void obtenerCVV(){
        wait.until(ExpectedConditions.visibilityOf(labelCVV));
        cvv = labelCVV.getText().replace("CVV:- ","");
        System.out.println(cvv);
    }
    public void obtenerFecha(){
        wait.until(ExpectedConditions.visibilityOf(labelFecha));
        String fecha[] = labelFecha.getText().replace("Exp:- ","").split("/");
        mes = fecha[0];
        anio = fecha[1];
        System.out.println(fecha + "/" + anio);
    }

    public void posicionarUltimaVentana(){
        Set<String> ventanas = driver.getWindowHandles();
        for (String ventana:ventanas){
            driver.switchTo().window(ventana);
        }
    }

    public void cerrarVentana(){
        driver.close();
    }

    public void posicionarVentanaInicial(){
        driver.switchTo().window("");
    }

}
