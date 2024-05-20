package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.test;

import com.github.javafaker.Faker;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints.UserEndPoints;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.payload.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;

    User userPayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}