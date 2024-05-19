package com.selenium.seleniumTestNG.restAssured.apiChaining;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser extends BaseClass {

    @Test
    public void createUser(ITestContext context) {

        Faker faker = new Faker();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");


        int id = given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())

                .when()
                .post(url)
                .jsonPath().getInt("id");

        System.out.println("Generated id is ---> " + id);
        //test lvl
//        context.setAttribute("userId",id);
        //suite lvl
        context.getSuite().setAttribute("userId", id);
    }
}