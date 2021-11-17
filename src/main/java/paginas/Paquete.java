package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Paquete extends Vuelo{

    private By texto = By.id("lbl_info_salida");
    private By selPaquete = By.xpath("//*[@id=\"vuelosIda_1\"]/div[2]/div[2]");
    private By confirmarPaqute = By.xpath("//*[@id=\"widget_resumen_reserva\"]/table[3]/tbody/tr/td/div");

    public Paquete(WebDriver webDriver){super(webDriver);}

    public Pago confirmacion(){

        WebDriverWait wait = new WebDriverWait(webDriver, 15);

        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(texto)));
        wait.until(ExpectedConditions.elementToBeClickable(selPaquete));

        webDriver.findElement(selPaquete).click();
        webDriver.findElement(confirmarPaqute).click();

        return new Pago(webDriver);
    }
    public String getLoadedText(){
        WebElement we = webDriver.findElement(texto);
        return(we.getText());
    }
}
