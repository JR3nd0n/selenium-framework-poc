package com.mesaj.app.builders.data;

import com.mesaj.app.enums.Gender;
import com.mesaj.app.models.User;
import com.mesaj.app.until.RandonNumberGenerator;

public class UserBuilder {

    private User user;

    private UserBuilder(){
        user =User.builder().build();
    }

    public  static  UserBuilder anUser(){
        //se retorna una instancia del UserBuilder para que permita hacer el
        //encadenamiento
        return  new UserBuilder();
    }
    public UserBuilder but(){
        return  withDefaultInfo();
    }

    public  UserBuilder withDefaultInfo(){
        this.user = User.builder()
        .firstName("John")
        .lastName("Cruz")
        .email("jpruebas.23@gmail.com")
        .gender(Gender.male)
        .country("Mexico")
        .birthDay("1")
        .birthMonth("November")
        .birthYear("1990")
        .phone(RandonNumberGenerator.get())
        .password("A_b123@")
        .passwordConfirmation("A_b123@").build();

        return  this;
    }
    //este metodo es construir un user mandando el campo email vacio
    public UserBuilder withOutEmail(){
        user.setEmail("");
        return this;
    }

    //este metodo es construir un user mandando el campo birthday vacio
    public UserBuilder withOutBirthDay(){
        user.setBirthDay("");
        return this;
    }


    public  User build(){
        return this.user;
    }
}
