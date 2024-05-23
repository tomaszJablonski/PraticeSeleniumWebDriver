package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.test;

import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints.UserEndPoints;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.payload.User;
import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTests {

    @Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
    public void testPostUser(
            String userID, String userName, String firstName,
            String lastName, String userEmail, String password,
            String phone) {

        User userPayload = new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(userEmail);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){
        Response response = UserEndPoints.deleteUser(userName);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(),200);

    }

}