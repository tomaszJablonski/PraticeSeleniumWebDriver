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
}