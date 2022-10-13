package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class PrincipalPage extends BasePage{

    @FindBy(id = "input-email")
    private WebElement correo;

    @FindBy(id = "input-password")
    private WebElement contrasena;

    @FindBy(id = "buttonLogin")
    private WebElement boton;

    @FindBy(id = "inicio")
    private WebElement botonInicio;

    @FindBy(id = "secciones")
    private WebElement botonSecciones;

    @FindBy(id = "usuarios")
    private WebElement botonUsuarios;

    @FindBy(id = "materias")
    private WebElement botonMaterias;

    @FindBy(id = "eventos")
    private WebElement botonEventos;

    @FindBy(id = "input-Tipo de usuario:")
    private WebElement tipoUsuarioCheckBox;

    @FindBy(id = "input-Nombre:")
    private WebElement nombreUsuario;

    @FindBy(id = "input-Correo:")
    private WebElement correoUsuario;

    @FindBy(id = "input-Contraseña:")
    private WebElement contrasenaUsuario;

    @FindBy(id = "formButton")
    private WebElement botonFormulario;

    public PrincipalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean CrearUsuarioCorrectamente(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(boton);
        clickOnElement(botonUsuarios);
        clickOnElement(tipoUsuarioCheckBox);
        WebElement element = driver.findElement(By.xpath("//option[contains(@value, 'Administrador')]"));
        clickOnElement(element);
        typeOnElement(this.nombreUsuario, "Maria Gomez");
        typeOnElement(this.correoUsuario, "maria@gmail.com");
        typeOnElement(this.contrasenaUsuario, "manito");
        clickOnElement(botonFormulario);
        return true;
    }

    public boolean CrearUsuarioCorreoIncorrecto(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(boton);
        clickOnElement(botonUsuarios);
        clickOnElement(tipoUsuarioCheckBox);
        WebElement element = driver.findElement(By.xpath("//option[contains(@value, 'Administrador')]"));
        clickOnElement(element);
        typeOnElement(this.nombreUsuario, "Maria Gomez");
        typeOnElement(this.correoUsuario, "mariagmail.com");
        typeOnElement(this.contrasenaUsuario, "manito");
        clickOnElement(botonFormulario);
        List<WebElement> elements = driver.findElements(By.xpath("//tr[contains(@class, 'thingsRow')]"));
        waitElement();
        if(elements.size() == 3){
            return false;
        }
        return true;
    }


    public boolean RegistroSinContrasena(String correo, String contrasena){
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(boton);
        clickOnElement(botonUsuarios);
        clickOnElement(tipoUsuarioCheckBox);
        WebElement element = driver.findElement(By.xpath("//option[contains(@value, 'Administrador')]"));
        clickOnElement(element);
        typeOnElement(this.nombreUsuario, "Carmen Maria");
        typeOnElement(this.correoUsuario, "carmen@gmail.com");
        typeOnElement(this.contrasenaUsuario, "");
        clickOnElement(botonFormulario);
        if(driver.findElement(By.xpath("//div[contains(@class, 'swal2-container')]")).isEnabled()){
            return true;
        }
        return false;
    }


    public boolean ConfirmacionSiEliminaProfesor(){
        scrollPage();
        findElement("//h5[contains(text(), 'Widgets')]");
        return driver.findElement(By.xpath("//div[contains(@class, 'show')]")) != null;
    }
    /*
    public boolean ConfirmacionSiActualizaProfesor(){
        scrollPage();
        findElement("//h5[contains(text(), 'Interactions')]");
        return driver.findElement(By.xpath("//div[contains(@class, 'show')]")) != null;
    }

    public boolean CrearSeccionSinProfesor(){
        scrollPage();
        findElement("//h5[contains(text(), 'Book Store Application')]");
        return driver.findElement(By.xpath("//div[contains(@class, 'show')]")) != null;
    }

    public boolean CrearSeccionSinMateriasEspecial(){

        return verifyStatusOfPage("https://demoqa.com/");
    }

    public boolean ConfirmacionEliminaSeccion(){
       findElement("//div[contains(@class, 'home-banner')]");
       return switchTabsAndVerifyStatusOfPage();

    }

    public boolean ConfirmacionActualizaSeccion(){
        return true;
    }

    public boolean ConfirmacionEliminaMateria(){
        return true;
    }

    public boolean ConfirmacionActualizaMateria(){
        return true;
    }
*/
}

