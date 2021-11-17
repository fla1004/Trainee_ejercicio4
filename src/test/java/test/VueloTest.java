package test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import paginas.Buscar;
import paginas.Confirmacion;
import paginas.Pago;
import paginas.Paquete;
import org.testng.Assert;

public class VueloTest extends BaseTest {

    @Test
    public void configuracion(){

        Buscar buscarVuelo = new Buscar(webDriver);

        Paquete sp =  buscarVuelo.BuscarVuelo("COCHABAMBA", "TARIJA", true, "11/29/2021");

        Pago pg = sp.confirmacion();

        Confirmacion cn = pg.pagoVuelo("Julian", "Perez","CI", "874589", "6547854", "juls34@gmail.com", "06/28/1987");

        Assert.assertEquals(cn.textoReserva(), "CODIGO DE RESERVA");
    }
}
