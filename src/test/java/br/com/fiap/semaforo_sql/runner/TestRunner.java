package br.com.fiap.semaforo_sql.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"br/com/fiap/semaforo_sql/steps"},
        tags = "@regressivo",
        plugin = {"html:target/cucumber-reports.html"}
)
public class TestRunner {
}