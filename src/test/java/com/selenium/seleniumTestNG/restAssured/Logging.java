package com.selenium.seleniumTestNG.restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Logging {

    @Test(priority = 1)
    public void testLogsAll(){
        //log all
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .log().all();
    }
    @Test(priority = 2)
    public void testLogsBody(){
        //log only response
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .log().body();
    }

    @Test(priority = 3)
    public void testLogsCookies(){
        //log only response
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .log().cookies();
    }

    @Test(priority = 4)
    public void testLogsHeaders(){
        //log only response
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .log().headers();
    }
}
