package com.selenium.seleniumTestNG.restAssured.apiChaining;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CRUD extends BaseClass {

    int id;

    @Test(priority = 1)
    public void createUser(ITestContext context) {

        Faker faker = new Faker();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");


        id = given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())

                .when()
                .post(url)
                .jsonPath().getInt("id");

        System.out.println("Generated id is ---> " + id);

        context.getSuite().setAttribute("userId", id);
    }

    @Test(priority = 2)
    public void getUser(ITestContext context) {

        id = (Integer) context.getSuite().getAttribute("userId");

        given()
                .header("Authorization", "Bearer " + bearerToken)
                .pathParam("id", id)

                .when()
                .get(url + "/{id}")

                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 3)
    public void updateUser(ITestContext context) {
        Faker faker = new Faker();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");

        id = (Integer) context.getSuite().getAttribute("userId");

        given()
                .header("Authorization", "Bearer " + bearerToken)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(jsonObject.toString())

                .when()
                .put(url + "/{id}")

                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4)
    public void deleteUser(ITestContext context) {

        id = (Integer) context.getSuite().getAttribute("userId");

        given()
                .header("Authorization", "Bearer " + bearerToken)
                .pathParam("id", id)

                .when()
                .delete(url + "/{id}")

                .then()
                .log().body();
    }
}