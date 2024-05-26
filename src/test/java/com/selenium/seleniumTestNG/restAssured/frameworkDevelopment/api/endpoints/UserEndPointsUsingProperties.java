package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints;

import com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

//Using restAssuredRoutes.properties

//Created for perform CRUD requests
//to the user API
public class UserEndPointsUsingProperties {

    //method created for getting URL`s from properties file
    public static ResourceBundle getUrl(){
        //load the properties file
        return ResourceBundle.getBundle("restAssuredRoutes");
    }

    public static Response createUser(User payload) {

        String postUrl = getUrl().getString("post_url");

        Response response =
                given()

                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)

                        .when()
                        .post(postUrl);

        return response;
    }

    public static Response readUser(String username) {

        String getUrl = getUrl().getString("get_url");

        Response response =
                given()
                        .pathParam("username", username)

                        .when()
                        .get(getUrl);

        return response;
    }

    public static Response updateUser(String username,User payload) {

        String updateUrl = getUrl().getString("update_url");


        Response response =
                given()

                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .pathParam("username", username)

                        .when()
                        .put(updateUrl);

        return response;
    }

    public static Response deleteUser(String username) {

        String deleteUrl = getUrl().getString("delete_url");


        Response response =
                given()
                        .pathParam("username", username)

                        .when()
                        .delete(deleteUrl);

        return response;
    }
}