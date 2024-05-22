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

    @Test(priority = 2)
    public void testGetUserByName(){
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        //update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(),200);
        //Check data after update
        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
    }
}