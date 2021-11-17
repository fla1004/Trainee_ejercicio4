package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pago extends Vuelo {

    private By fpNombre = By.id("tbx_px1_nombres");
    private By fpApellidos = By.id("tbx_px1_apellidos");
    private By fpDocumento = By.id("select_px1_tipo_documento");
    private By fpNumeroDocumento = By.id("tbx_px1_documento");
    private By fpTelefono = By.id("tbx_px1_telefono");
    private By fpEmail = By.id("tbx_px1_email");
    private By fpFechaNacimiento = By.id("picker_px1_nacimiento");

    private By confirmarPago =  By.xpath("/html/body/div[2]/div[1]/div[4]/div/table/tbody/tr/td/div");

    public Pago(WebDriver webDriver){super(webDriver);}

    private void escribirEnter(String text, By elementBy){
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public Confirmacion pagoVuelo(String nombre,String apellido, String documento,
                                  String numDocumento,String telefono, String email,
                                  String fechaNacimiento){

        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(fpNombre));

        webDriver.findElement(fpNombre).sendKeys(nombre);
        webDriver.findElement(fpApellidos).sendKeys(apellido);
        selectByVisibleText(documento, fpDocumento);
        webDriver.findElement(fpNumeroDocumento).sendKeys(numDocumento);
        webDriver.findElement(fpTelefono).sendKeys(telefono);
        webDriver.findElement(fpEmail).sendKeys(email);
        escribirEnter(fechaNacimiento,fpFechaNacimiento);
        webDriver.findElement(confirmarPago).click();

        return new Confirmacion(webDriver);

    }

}
