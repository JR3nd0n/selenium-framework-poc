package com.mesaj.app.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("cucumber-glue")
@Component
@Getter
public class SignUpPageObject extends PageBase{

    @Autowired//Inyeccion de depencias por constructor
    public SignUpPageObject(WebDriver driver){
        //llamada al constructor de la clase
        super(driver);
    }
    //Page Elements
    // se restructura con pagefactory convirtiendo el by a webelement
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
    private WebElement firsNameTextbox;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
    private WebElement lastName;
    @FindBy(xpath = "//*[@id=\"eid\"]/input")
    private WebElement emailAddress;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
    private WebElement phone;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")
    private WebElement genderMale ;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")
    private  WebElement genderFemale;
    @FindBy(id = "countries")
    private WebElement country;
    @FindBy(id = "yearbox")
    private WebElement dateOfBirdYear;
    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")
    private WebElement dateOfBirthMonth;
    @FindBy(id = "daybox")
    private WebElement dateOfBirthDay;
    @FindBy(id = "firstpassword")
    private WebElement password;
    @FindBy(id = "secondpassword")
    private WebElement confirmPassword ;
    @FindBy(id = "submitbtn")
    private WebElement submit;

}
