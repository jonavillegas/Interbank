package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.carritoPage;
import pageobjects.menuPage;
import pageobjects.pagoPage;
import pageobjects.tarjetaPage;

public class HistoriaCarritoCompraDefinition {

    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;

    public HistoriaCarritoCompraDefinition() {
        menu = new menuPage(Hooks.driver);
        tarjeta = new tarjetaPage(Hooks.driver);
        carrito = new carritoPage(Hooks.driver);
        pago = new pagoPage(Hooks.driver);
    }

    @Given("validar que la web este disponible")
    public void validarQueLaWebEsteDisponible() {
        Hooks.driver.get("http://demo.guru99.com/payment-gateway/index.php");
    }

    @When("generar tarjeta valida")
    public void generarTarjetaValida() {
        menu.clickGenerarTarjeta();
    }

    @And("obtener los datos de la tarjeta")
    public void obtenerLosDatosDeLaTarjeta() {
        tarjeta.posicionarUltimaVentana();
        tarjeta.obtenerTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        tarjeta.cerrarVentana();
        tarjeta.posicionarVentanaInicial();

    }

    @And("seleccionar la catidad {string}")
    public void seleccionarLaCatidad(String cantidad) {
        carrito.seleccionarCantidad(cantidad);
    }

    @And("comprar el producto")
    public void comprarElProducto() {
        carrito.clickComprar();
    }

    @And("ingresar los datos de la tarjeta")
    public void ingresarLosDatosDeLaTarjeta() {
        pago.validarTitulo();
        pago.escribirTarjeta(tarjetaPage.tarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCvv(tarjetaPage.cvv);
    }


    @And("pagar el producto")
    public void pagarElProducto() {
        pago.clickPagar();
    }

}








