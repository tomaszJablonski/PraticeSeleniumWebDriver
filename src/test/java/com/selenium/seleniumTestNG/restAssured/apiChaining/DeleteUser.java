package com.selenium.seleniumTestNG.restAssured.apiChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser extends BaseClass {

    @Test
    public void deleteUser(ITestContext context){

        //test lvl
//        int id = (Integer) context.getAttribute("userId");
        //suite lvl
        int id = (Integer) context.getSuite().getAttribute("userId");

        given()
                .header("Authorization","Bearer " + bearerToken)
                .pathParam("id",id)

                .when()
                .delete(url + "/{id}")

                .then()
                .log().body();
    }
}