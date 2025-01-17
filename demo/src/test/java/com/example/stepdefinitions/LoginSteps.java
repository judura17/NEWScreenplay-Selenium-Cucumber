package com.example.stepdefinitions;

import com.example.context.SharedContext;
import com.example.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final SharedContext sharedContext;
    private LoginPage loginPage;

    // Llamado al metodo Hooks
    public LoginSteps(SharedContext sharedContext) {
        this.sharedContext = sharedContext;
    }

    // Dado
    @Given("Este en la pagina de logueo de la pagina HRM")
    public void i_am_on_the_login_page() {
        sharedContext.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(sharedContext.driver);
    }

    // Cuando
    @When("Ingrese las credenciales de usuario y contraseña")
    public void i_login_with_ussername_and_password() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

    }

    // Luego
    @Then("Deberia de ingresar al portal de la pagina")
    public void i_should_be_in_the_dashboard() {
        assertTrue(sharedContext.driver.getCurrentUrl().contains("dashboard"));

    }

}
