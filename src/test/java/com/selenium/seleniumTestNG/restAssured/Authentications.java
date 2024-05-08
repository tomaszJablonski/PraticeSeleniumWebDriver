package com.selenium.seleniumTestNG.restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {
    //Basic - username and password user

    @Test
    public void testBasicAuthentication() {
        given()
                .auth().basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    //Digest - username and password user

    @Test(priority = 2)
    public void testDigestAuthentication() {
        given()
                .auth().digest("postman", "password")

                .when()
                    .get("https://postman-echo.com/digest-auth")

                .then()
                    .statusCode(200)
                    .body("authenticated", equalTo(true))
                    .log().body();
    }

    //Preemptive - username and password user

    @Test(priority = 3)
    public void testPreemptiveAuthentication() {
        given()
                .auth().preemptive().basic("postman", "password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().body();
    }

    //Bearer Token

    @Test(priority = 4)
    public void testBearerTokenAuthentication(){
        /*
        1.To generate a GitHub token, follow these steps12:
        2.Log in to your GitHub account.
        3.Go to the Settings of your account.
        4.In the left sidebar, click on Developer settings.
        5.Select Personal access tokens.
        6.Click on the Generate new token button.
        7.Provide a meaningful note for the token to help identify its purpose.
        8.Select the desired scopes/permissions for the token based on your requirements.
        9.Click on the Generate token button.
         */

        String bearerToken = "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";

        given()
                .headers("Authorization","Bearer " + bearerToken)

                .when()
                .get("https://api.github.com/user/repos")

                .then()
                .statusCode(200)
                .log().all();
    }

    //oauth 1.0

    @Test(priority = 5,enabled = false,testName = "only syntax")
    public void testOAuth1Authentication(){
        given()
                .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")

                .when()
                .get("url")

                .then()
                .statusCode(200)
                .log().all();
    }

    //oauth 2.0

    @Test(priority = 6)
    public void testOAuth2Authentication(){
        given()
                .auth().oauth2("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")

                .when()
                .get("https://api.github.com/users/mojombo")

                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 7)
    public void testAPIKeyAuthentication(){
        given()
                .auth().oauth2("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")

                .when()
                .get("https://api.github.com/users/mojombo")

                .then()
                .statusCode(200)
                .log().all();
    }

//    8ca6b067124be2905cd0a317e91eb35d




}
