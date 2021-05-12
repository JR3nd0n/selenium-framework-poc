package com.mesaj.app.until.reporting;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class PhotographerHook {
    @Autowired
    private WebDriver webDriver;
    @Value("${take.screenshot.condition:none}")
    private TakeScreenshotCondition takeScreenshotCondition;

    @After
    public  void takeScreenShotAfterScenario(Scenario scenario) {
        if(TakeScreenshotCondition.everyStep==takeScreenshotCondition)
            takeScreenShot(scenario);

        }
    @AfterStep
    public  void takeScreenShotAfterEveryStep(Scenario scenario) {
        if(TakeScreenshotCondition.everyStep==takeScreenshotCondition)
            takeScreenShot(scenario);


    }
    @After
    public  void takeScreenShotAfterFailingScenario(Scenario scenario) {
        if(scenario.isFailed()&& TakeScreenshotCondition.failingScenario==takeScreenshotCondition)
            takeScreenShot(scenario);

    }

    private void takeScreenShot(Scenario scenario){
        try{
            //llamada a funcion de webdriver que se encarga de tomar screenshot
            final byte [] screenshot= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png", UUID.randomUUID().toString());

        }
        catch(WebDriverException wde){
            System.out.println("There was an error taking the screenshot");
        }
    }
}
