package com.mesaj.app.conf;

import com.mesaj.app.enums.Browser;
import com.mesaj.app.until.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DriverConfg{

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int  webDriverWaitTimeOut;

    @Autowired
    private  DriverFactory driverFactory;

    @Scope("cucumber-glue")
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() {
       return driverFactory.get(driverType);
    }
    @Bean
    @Scope("cucumber-glue")
    public WebDriverWait waitFor(){
        return new WebDriverWait(webDriver(),webDriverWaitTimeOut);
    }

}
