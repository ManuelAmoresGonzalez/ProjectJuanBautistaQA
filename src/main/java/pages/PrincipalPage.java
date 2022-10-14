package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class PrincipalPage extends BasePage{

    @FindBy(id = "input-email")
    private WebElement correo;

    @FindBy(id = "input-password")
    private WebElement contrasena;

    @FindBy(id = "buttonLogin")
    private WebElement botonLogin;

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

    @FindBy(id = "input-Docente asginado:")
    private WebElement profesorCheckBox;

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
        clickOnElement(botonLogin);
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
        clickOnElement(botonLogin);
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
        clickOnElement(botonLogin);
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


    public boolean ConfirmacionSiEliminaProfesor(String correo, String contrasena){
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonUsuarios);
        List<WebElement> valores = driver.findElements(By.xpath("//td[contains(@class, 'actions-buttons')]"));
        clickOnElement(valores.get(1));
        //WebElement borrar = driver.findElement(By.xpath("//button[contains(@class, 'confirm-button')]"));
        //clickOnElement(borrar);
        return true;
    }

    public boolean ConfirmacionSiActualizaProfesor(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonUsuarios);
        List<WebElement> valores = driver.findElements(By.xpath("//button[contains(@class, 'edit-btn')]"));
        clickOnElement(valores.get(1));
        waitElement();
        if(driver.findElement(By.xpath("//div[contains(@class, 'react-responsive-modal-modal')]")).isEnabled()){
            return true;
        }
        return false;
    }

    public boolean CrearSeccionSinProfesor(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonSecciones);
        typeOnElement(this.nombreUsuario, "1-2");
        clickOnElement(botonFormulario);
        waitElement();
        if(driver.findElement(By.xpath("//div[contains(@class, 'swal2-container')]")).isEnabled()){
            return true;
        }
        return false;
    }

    public boolean CrearSeccionSinMateriasEspecial(String correo, String contrasena){
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonSecciones);
        return true;
    }

    public boolean ConfirmacionEliminaSeccion(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonSecciones);
        List<WebElement> valores = driver.findElements(By.xpath("//button[contains(@class, 'delete-btn')]"));
        clickOnElement(valores.get(0));
        waitElement();
        return true;
    }

    public boolean ConfirmacionActualizaSeccion(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonSecciones);
        List<WebElement> valores = driver.findElements(By.xpath("//button[contains(@class, 'edit-btn')]"));
        clickOnElement(valores.get(0));
        waitElement();
        return true;
    }

    public boolean ConfirmacionEliminaMateria(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonMaterias);
        List<WebElement> valores = driver.findElements(By.xpath("//button[contains(@class, 'delete-btn')]"));
        clickOnElement(valores.get(0));
        waitElement();
        return true;
    }

    public boolean ConfirmacionActualizaMateria(String correo, String contrasena) throws InterruptedException{
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonSecciones);
        List<WebElement> valores = driver.findElements(By.xpath("//button[contains(@class, 'edit-btn')]"));
        clickOnElement(valores.get(0));
        waitElement();
        return true;
    }

    //Iteración 2

/*

    public boolean ProfesorGuiaSoloObservaSuHorario(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }

    public boolean AdministradorObservaCualquierHorario(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }
    public boolean ProfesorEspecialNoModificaHorario(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }
    public boolean ModalDeCreadoSiSePresionaEnviar(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }
    public boolean NoRegistraDatosSiPresionaX(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }
    public boolean UnHorarioAlProfesorGuia(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }
    public boolean HorarioMananaTardeProfesorEspecial(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }

    public boolean AdministradorNoEditaProfesorGuia(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        return true;
    }

 */
    public boolean AdministradorEditaProfesorEspecial(String correo, String contrasena) throws InterruptedException {
        typeOnElement(this.correo, correo);
        typeOnElement(this.contrasena, contrasena);
        clickOnElement(botonLogin);
        clickOnElement(botonUsuarios);
        List<WebElement> valores = driver.findElements(By.xpath("//div[contains(@id, 'principalRow')]"));
        System.out.println("Tamaño: "+valores.size());
        waitElement();
        scrollPage();
        clickOnElement(valores.get(1));
        return true;
    }
}

