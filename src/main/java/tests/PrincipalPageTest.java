package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PrincipalPage;

public class PrincipalPageTest {
    WebDriver driver;
    BasePage basePage;

    @BeforeMethod
    private void setUp(){
        WebDriverManager.chromedriver().browserVersion("100.0.4896.60").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--allowed-ips");
        driver = new ChromeDriver(options);
        basePage = new BasePage(driver);
        driver.get("http://localhost:3000/");
    }


//Pruebas Iteracion 1
    /*
    @Test
    private void CrearUsuarioCorrectamente() throws InterruptedException {
        PrincipalPage element = new PrincipalPage(driver);
        Assert.assertTrue(element.CrearUsuarioCorrectamente("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void CrearUsuarioCorreoIncorrecto() throws InterruptedException {
        PrincipalPage form = new PrincipalPage(driver);
        Assert.assertTrue(form.CrearUsuarioCorreoIncorrecto("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void RegistroSinContrasena() throws InterruptedException {
        PrincipalPage alertsFrameAndWindows = new PrincipalPage(driver);
        Assert.assertTrue(alertsFrameAndWindows.RegistroSinContrasena("m@gmail.com","manito"));
        driver.close();
    }



    @Test
    private void ConfirmacionSiEliminaProfesor(){
        PrincipalPage widgets = new PrincipalPage(driver);
        Assert.assertTrue(widgets.ConfirmacionSiEliminaProfesor("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ConfirmacionSiActualizaProfesor() throws InterruptedException {
        PrincipalPage interactions = new PrincipalPage(driver);
        Assert.assertTrue(interactions.ConfirmacionSiActualizaProfesor("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void CrearSeccionSinProfesor() throws InterruptedException {
        PrincipalPage bookStoreApplication = new PrincipalPage(driver);
        Assert.assertTrue(bookStoreApplication.CrearSeccionSinProfesor("m@gmail.com","manito"));
        driver.close();
    }
    @Test
    private void CrearSeccionSinMateriasEspecial(){
        PrincipalPage pageLoaded = new PrincipalPage(driver);
        Assert.assertTrue(pageLoaded.CrearSeccionSinMateriasEspecial("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ConfirmacionEliminaSeccion() throws InterruptedException {
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionEliminaSeccion("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ConfirmacionActualizaSeccion() throws InterruptedException {
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionActualizaSeccion("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ConfirmacionEliminaMateria() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionEliminaMateria("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ConfirmacionActualizaMateria() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionActualizaMateria("m@gmail.com","manito"));
        driver.close();
    }

*/
    //Pruebas iteracion 2

    @Test
    private void AdministradorEditaProfesorEspecial() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.AdministradorEditaProfesorEspecial("m@gmail.com","manito"));
        //driver.close();
    }

/*
    @Test
    private void AdministradorNoEditaProfesorGuia() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.AdministradorNoEditaProfesorGuia("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void HorarioMananaTardeProfesorEspecial() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.HorarioMananaTardeProfesorEspecial("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void UnHorarioAlProfesorGuia() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.UnHorarioAlProfesorGuia("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void NoRegistraDatosSiPresionaX() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.NoRegistraDatosSiPresionaX("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ModalDeCreadoSiSePresionaEnviar() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ModalDeCreadoSiSePresionaEnviar("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ProfesorEspecialNoModificaHorario() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ProfesorEspecialNoModificaHorario("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void ProfesorGuiaSoloObservaSuHorario() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ProfesorGuiaSoloObservaSuHorario("m@gmail.com","manito"));
        driver.close();
    }

    @Test
    private void AdministradorObservaCualquierHorario() throws InterruptedException{
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.AdministradorObservaCualquierHorario("m@gmail.com","manito"));
        driver.close();
    }
*/

}
