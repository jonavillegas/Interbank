package pageobjects;

//import com.sun.xml.internal.stream.events.StartElementEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class carritoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "quantity" ) private WebElement comboCantidad;
    @FindBy(xpath = "//input[@value='Buy Now']") private WebElement buttonComprar;

    public carritoPage(WebDriver dvr){
        driver = dvr;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void seleccionarCantidad(String cantidad){
        wait.until(ExpectedConditions.visibilityOf(comboCantidad));
        new Select(comboCantidad).selectByVisibleText(cantidad);
    }

    public void clickComprar(){
        buttonComprar.click();
    }

}
