package com.mesaj.app;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features",
        plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber",
                "pretty","json:target/Cucumber-reports/Cucumber.json"
}
        )
public class CucumberTest {
}
