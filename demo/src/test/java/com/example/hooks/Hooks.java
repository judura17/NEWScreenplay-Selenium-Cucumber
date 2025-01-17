package com.example.hooks;

import com.example.context.SharedContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private final SharedContext sharedContext;

    // Metodo que permite levantar el navegador
    public Hooks(SharedContext sharedContext) {
        this.sharedContext = sharedContext;
    }

    // Cuando se ejecuta el TestRunner, primero valida el antes
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\JAIRO ALONSO\\Documents\\PROGRAMACION OJDR\\NEWScreenplay-Selenium-Cucumber\\demo\\src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        sharedContext.driver = driver;
    }

    // Cuando se ejecuta el TestRunner, finaliza validando el despues
    @After
    public void tearDown() {
        if (sharedContext.driver != null) {
            sharedContext.driver.quit();
        }
    }

}
