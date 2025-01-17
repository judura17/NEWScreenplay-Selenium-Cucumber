package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Elementos de la pagina del login
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath(("//button[@type='submit']"));

    // Constructor que hereda de la clase BasePage
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Metodos de interaccion de la pagina login

    public void enterUsername(String username) {
        waitForElement(usernameField, Duration.ofSeconds(30));
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

}
