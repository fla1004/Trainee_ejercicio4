package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class Vuelo{
    protected WebDriver webDriver;
    public Vuelo(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    protected void selectByVisibleText(String option, By selectBy){
        Select toSelect = new Select(webDriver.findElement(selectBy));
        toSelect.selectByVisibleText(option);
    }

}
