package com.mesaj.app.pageobjects;

import com.mesaj.app.enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class SignUpServices {
    @Autowired//Inyeccion de depencias por constructor a traves de spring
    private  SignUpPageObject signUpPageObject;

    @Autowired
    private WebDriver driver;

    @Autowired
    WebDriverWait wait;

    //Page services into elements
    public  void goUrl(String url){
        this.driver.get(url);
        driver.manage().window().maximize();
    }

    public void writeFirstName (String firstname){
        this.wait.until(ExpectedConditions.visibilityOf(this.signUpPageObject.getFirsNameTextbox()));
        this.signUpPageObject.getFirsNameTextbox().sendKeys(firstname);
    }
    public void writeLastName(String lastName){
        this.signUpPageObject.getLastName().sendKeys(lastName);
    }
    public void writeEmail(String email){
        this.signUpPageObject.getEmailAddress().sendKeys(email);
    }
    public void writePhone(String phone){
        this.signUpPageObject.getPhone().sendKeys(phone);
    }
    private void selectMale(){
        this.signUpPageObject.getGenderMale().click();
    }
    private void selectFemale(){
        this.signUpPageObject.getGenderFemale().click();
    }
    public void selecCountry(String country){
        new Select(this.signUpPageObject.getCountry()).selectByValue(country);
    }
    public void selectBirthDay(String day){
        new Select(this.signUpPageObject.getDateOfBirthDay()).selectByValue(day);
    }
    public void selectBirthMonth(String month){
        new Select(this.signUpPageObject.getDateOfBirthMonth()).selectByValue(month);
    }
    public void selectBirthYear(String year){
        new Select(this.signUpPageObject.getDateOfBirdYear()).selectByValue(year);
    }
    public  void  writePassword(String password){
        this.signUpPageObject.getPassword().sendKeys(password);
    }
    public void writeConfirmPassword(String confirPassword){
        this.signUpPageObject.getConfirmPassword().sendKeys(confirPassword);
    }
    public  void clickOnSubmit(){
        this.signUpPageObject.getSubmit().click();
    }
    public void selectGender(Gender gender){
        if (gender == Gender.female){
            selectFemale();
        }else{
            selectMale();
        }
    }
}
