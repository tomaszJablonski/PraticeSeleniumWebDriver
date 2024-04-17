package com.selenium.seleniumTestNG.restAssured;

/*
given() - content type, set cookies, add auth,
          add param, set headers info etc...
when() - get,post,put, delete
then() - validate status code, extract response,
         extract headers cookies, response body ....
 */

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HttpRequests {

    /*
    https://reqres.in/
    GET
    /api/users/2 - one user
    /api/users?page=2 - list of users

    Post
    /api/users
    {
    "name": "morpheus",
    "job": "leader"
     }

     Put
     /api/users/2
     {
    "name": "morpheus",
    "job": "zion resident"
     }

     Delete
     /api/users/2
     */

      @Test
      public void getUsers(){
          given()

          .when()
                  .get("https://reqres.in/api/users?page=2")

          .then()
                  .statusCode(200)
                  .body("page", equalTo(2))
                  .log().all();

      }

}
