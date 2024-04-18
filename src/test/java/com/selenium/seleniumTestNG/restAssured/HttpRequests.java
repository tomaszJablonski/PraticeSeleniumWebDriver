package com.selenium.seleniumTestNG.restAssured;

/*
given() - content type, set cookies, add auth,
          add param, set headers info etc...
when() - get,post,put, delete
then() - validate status code, extract response,
         extract headers cookies, response body ....
 */

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HttpRequests {

    int id;

    /*
    https://reqres.in/
     */

    @Test(priority = 1)
    public void getUsers() {
//          GET
//          /api/users/2 - one user
//          /api/users?page=2 - list of users
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();

    }

    @Test(priority = 2)
    public void createUser() {
//          Post
//          /api/users
//          {
//              "name": "morpheus",
//                  "job": "leader"
//          }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "morpheus");
        hashMap.put("job", "leader");

        id=given()
                .contentType("application/json")
                .body(hashMap)

       .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");



//       .then()
//                .statusCode(201)
//                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = ("createUser"))
    public void editUser(){
//        Put
//                /api/users/2
//        {
//            "name": "morpheus",
//                "job": "zion resident"
//        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "neo");
        hashMap.put("job", "zion resident");

        given()
                .contentType("application/json")
                .body(hashMap)

                .when()
                .put("https://reqres.in/api/users/" + id)

       .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    public void deleteUser(){
//        Delete
//                /api/users/2
        given()

                .when()
                        .delete("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(204)
                .log().all();
    }
}