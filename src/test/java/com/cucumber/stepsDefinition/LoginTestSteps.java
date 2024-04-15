package com.cucumber.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

    @Given("I am on the customer login page")
    public void i_am_on_the_customer_login_page() {
        System.out.println("I am in Given section");
    }

    @When("I provide valid login credentials")
    public void i_provide_valid_login_credentials() {
        System.out.println("I am in When section");
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        System.out.println("I am in And section");
    }

    @Then("I should be redirect to home page")
    public void i_should_be_redirect_to_home_page() {
        System.out.println("I am in Then section");
    }

    @Then("I close the browser dummy")
    public void iCloseTheBrowserDummy() {
        System.out.println("I close the browser");
    }

    @Given("My name is {string}")
    public void my_name_is_thomas(String name) {
        System.out.println(name);
    }

    @When("My surname is {string}")
    public void my_surname_is_marvel(String surname) {
        System.out.println(surname);
    }

    @When("I live in {string}")
    public void i_live_in_poland(String country) {
        System.out.println(country);
    }


}