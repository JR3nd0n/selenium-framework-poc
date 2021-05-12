package com.mesaj.app.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class PageBase {
    protected WebDriver webDriver;

    //inyeccion por constructor del driver
    public  PageBase(WebDriver driver){
        this.webDriver = driver;
        //inicializacion de la pagefactory
        PageFactory.initElements(webDriver,this);
    }
}
