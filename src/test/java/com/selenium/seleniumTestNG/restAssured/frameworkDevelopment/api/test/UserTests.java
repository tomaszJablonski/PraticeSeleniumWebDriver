package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.test;

import com.github.javafaker.Faker;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints.UserEndPoints;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints.UserEndPointsUsingProperties;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.payload.User;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    public Faker faker;

    public User userPayload;

    public Logger logger;

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

        //Logs
        logger = LogManager.getLogger(this.getClass());
        //add here and change in log4j2.xml in Loggers
        logger.debug("DEBUGGING");
    }

    @Test(priority = 1)
    public void testPostUser(){
        logger.info("***** Creating User ******");

        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***** User is Creating ******");

    }

    @Test(priority = 2)
    public void testGetUserByName(){
        logger.info("***** Reading user info ******");


        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);

        logger.info("***** User info is Displayed ******");
    }

    @Test(priority = 3)
    public void testUpdateUserByName(){
        logger.info("***** Updating user ******");

        //update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***** User is Updated ******");

        //Check data after update
        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        logger.info("***** Deleting the User ******");

        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        logger.info("***** User is Deleting ******");

    }

    //USING PROPERTIES

    @Test(priority = 5)
    public void testPostUserUsingProperties(){
        logger.info("***** Creating User ******");

        Response response = UserEndPointsUsingProperties.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***** User is Creating ******");

    }

    @Test(priority = 6)
    public void testGetUserByNameUsingProperties(){
        logger.info("***** Reading user info ******");


        Response response = UserEndPointsUsingProperties.readUser(this.userPayload.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(),200);

        logger.info("***** User info is Displayed ******");
    }

    @Test(priority = 7)
    public void testUpdateUserByNameUsingProperties(){
        logger.info("***** Updating user ******");

        //update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPointsUsingProperties.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("***** User is Updated ******");

        //Check data after update
        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.statusCode(),200);
    }

    @Test(priority = 8)
    public void testDeleteUserByNameUsingProperties(){
        logger.info("***** Deleting the User ******");

        Response response = UserEndPointsUsingProperties.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(),200);
        logger.info("***** User is Deleting ******");

    }
}