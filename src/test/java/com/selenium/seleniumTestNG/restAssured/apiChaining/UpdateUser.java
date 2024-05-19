package com.selenium.seleniumTestNG.restAssured.apiChaining;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser extends BaseClass {

    @Test
    public void updateUser(ITestContext context) {
        Faker faker = new Faker();

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", faker.name().fullName());
        jsonObject.put("gender", "Male");
        jsonObject.put("email", faker.internet().emailAddress());
        jsonObject.put("status", "inactive");

        //test lvl
//        int id = (Integer) context.getAttribute("userId");
        //suite lvl
        int id = (Integer) context.getSuite().getAttribute("userId");

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
}