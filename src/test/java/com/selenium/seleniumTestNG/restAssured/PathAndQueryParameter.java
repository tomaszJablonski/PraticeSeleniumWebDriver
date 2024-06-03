package com.selenium.seleniumTestNG.restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PathAndQueryParameter {

//    https://reqres.in/api/users?page=2&id=5

    @Test
    public void testPathAndQueryParameter(){
        given()
                .pathParam("myUsers","users") //path parameter
                .queryParam("page",2) //query parameter
                .queryParam("id",5) //second query parameter

                .when()
                .get("https://reqres.in/api/{myUsers}")

                .then()
                .statusCode(200)
                .log().all();
    }
}