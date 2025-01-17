package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\JAIRO ALONSO\\Documents\\PROGRAMACION OJDR\\NEWScreenplay-Selenium-Cucumber\\demo\\src\\test\\resources\\features", // Ruta
        // a
        // tus
        // archivos
        // .feature
        glue = { "com.example.stepdefinitions", "com.example.hooks" }, // Ruta
        // a
        // los
        // pasos
        // definidos
        tags = "@Recruitment", // Solo ejecuta escenarios con esta etiqueta
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json"
        }, monochrome = true)

public class TestRunner {

}
