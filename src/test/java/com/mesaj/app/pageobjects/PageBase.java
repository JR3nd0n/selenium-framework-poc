package com.mesaj.app.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class PageBase {
    protected WebDriver webDriver;

    //inyeccion por constructor del driver
    @Autowired
    public  PageBase(WebDriver webDriver){
        this.webDriver = webDriver;
        //inicializacion de la pagefactory
        PageFactory.initElements(webDriver,this);
    }
}
