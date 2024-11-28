package com.testing.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // La ruta de los archivos .feature
        glue = "com.testing.api.stepDefinitions", // La ruta de las clases Step Definitions
        tags = "@test1", // Puedes usar tags para ejecutar escenarios específicos
        plugin = {"pretty", "html:target/cucumber-report.html"} // Para generar el reporte
)
public class TestRunner {
}
