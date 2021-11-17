package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Confirmacion extends Vuelo{

    private By ftextoReserva =  By.xpath("//*[@id=\"cod_reserva\"]/tbody/tr[1]/td/h2");

    public  Confirmacion(WebDriver webDriver){super(webDriver);}

    public String textoReserva(){

        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(ftextoReserva)));

        WebElement we = webDriver.findElement(ftextoReserva);
        return(we.getText());
    }
}
