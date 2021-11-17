package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod
    public void config(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        webDriver = new ChromeDriver();

        webDriver.get("https://www.boa.bo/BoAWebsite");
    }

    @AfterMethod
    public void cerrar(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
}
