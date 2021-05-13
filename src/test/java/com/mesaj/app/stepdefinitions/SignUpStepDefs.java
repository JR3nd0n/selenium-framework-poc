package com.mesaj.app.stepdefinitions;

import com.mesaj.app.builders.data.UserBuilder;
import com.mesaj.app.tasks.NavigateTo;
import com.mesaj.app.tasks.UserSignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class SignUpStepDefs {
    @Autowired//Inyeccion de depencias por constructor
    private UserSignUp signUp;
    //llamada a nuestro NavigateTo
    @Autowired
    private NavigateTo navigate;


    @Given("^Jhon wants to have an account$")
    public void jhon_wants_to_have_an_account() {
        navigate.signUpPage();

    }
    @When("^He sends required information to get the account$")
    public void he_sends_required_information_to_get_the_account() {
        signUp.withInfo(
                UserBuilder
                        .anUser()
                        .but()
                        .withOutBirthDay()
                        .withOutEmail()
                        .build()
        );
    }

    @Then("^He should be told that the account was created$")
    public void he_should_be_told_that_the_account_was_created() {
        assertThat(true).isEqualTo(true);
        }
    @Then("^He should be told that the account was not created$")
    public void he_should_be_told_that_the_account_was_not_created() {
        assertThat(true).isEqualTo(false);
    }
    }
