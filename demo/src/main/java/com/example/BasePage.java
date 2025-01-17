package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    // Metodos de interaccion
    // Encontrar elemento en pantalla
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    // Escribir texto
    public void type(By locator, String inpuText) {
        findElement(locator).sendKeys(inpuText);
    }

    // Funcion para simular la pulsacion de teclas: DOWN + ENTER
    public void pressDownAndEnter(By locator) {
        findElement(locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .sendKeys(Keys.DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    // Hacer click en un elemento
    public void click(By locator) {
        findElement(locator).click();
    }

    // Obtener texto de un elemento
    public String getText(By locator) {
        return findElement(locator).getText();
    }

    // Espera hasta que el elemento sea visible
    public void waitForElement(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Espera hasta que un elemento esté presente en el DOM
    protected WebElement waitForElementPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Funcion para establecer una espera implicita
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

}
