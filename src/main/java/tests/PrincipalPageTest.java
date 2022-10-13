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

/*

    @Test
    private void CrearUsuarioCorrectamente() throws InterruptedException {
        PrincipalPage element = new PrincipalPage(driver);
        Assert.assertTrue(element.CrearUsuarioCorrectamente("m@gmail.com","manito"));
        //driver.close();
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
        //driver.close();

    }
*/
    @Test
    private void ConfirmacionSiActualizaProfesor(){
        PrincipalPage interactions = new PrincipalPage(driver);
        Assert.assertTrue(interactions.ConfirmacionSiActualizaProfesor());
        driver.close();
    }
/*
    @Test
    private void CrearSeccionSinProfesor(){
        PrincipalPage bookStoreApplication = new PrincipalPage(driver);
        Assert.assertTrue(bookStoreApplication.CrearSeccionSinProfesor());
        driver.close();

    }

    @Test
    private void CrearSeccionSinMateriasEspecial(){
        PrincipalPage pageLoaded = new PrincipalPage(driver);
        Assert.assertTrue(pageLoaded.CrearSeccionSinMateriasEspecial());
        driver.close();
    }

    @Test
    private void ConfirmacionEliminaSeccion(){
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionEliminaSeccion());
        driver.close();
    }

    @Test
    private void ConfirmacionActualizaSeccion(){
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionActualizaSeccion());
        driver.close();
    }

    @Test
    private void ConfirmacionEliminaMateria(){
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionEliminaMateria());
        driver.close();
    }

    @Test
    private void ConfirmacionActualizaMateria(){
        PrincipalPage openNewPage = new PrincipalPage(driver);
        Assert.assertTrue(openNewPage.ConfirmacionActualizaMateria());
        driver.close();
    }*/

}
