package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Buscar extends Vuelo{

    private By sDesde = By.id("select_desde");
    private By sA = By.id("select_hasta");
    private By sIda = By.xpath("//*[@id=\"rbtn_ida\"]");
    private By sDatepickerSalida = By.id("picker_salida");
    private By sButton = By.id("btn_buscar_vuelos");
    private By sCookies = By.id("btn_cookies");


    public Buscar(WebDriver webDriver){super(webDriver);}

    private void escribirEnter(String text, By elementBy){
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public  Paquete BuscarVuelo(String desde, String hasta,boolean soloIda, String fechaSalida){
        webDriver.findElement(sCookies).click();
        selectByVisibleText(desde, sDesde);
        selectByVisibleText(hasta, sA);
        webDriver.findElement(sIda).click();
        escribirEnter(fechaSalida, sDatepickerSalida);
        webDriver.findElement(sButton).click();

        return new Paquete(webDriver);

    }

}
