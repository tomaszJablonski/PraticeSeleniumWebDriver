package com.selenium.seleniumTestNG.restAssured;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class TestHeaders {

    @Test(priority = 1)
    public void testHeaders() {
        given()

                .when()
                .get("https://www.google.pl/")

                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-2")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws")
                .log().all();
    }

    //tego sie nie używa to tylko żeby zrozumieć
    @Test(priority = 2,enabled = false)
    public void getHeaders() {
        Response response = given()
                .when()
                .get("https://www.google.pl/");

        //get single header info
//        String headerValue = response.getHeader("Content-Type");
//        System.out.println("headerValue of Content-Type = " + headerValue);

        //get all headers info
        //Header  header name:value

        //Headers header name:value
        //        header name:value
        //        header name:value
        //        header name:value
       Headers myHeaders = response.getHeaders();

       for (Header header: myHeaders){
           System.out.println(header.getName() + " " +  header.getValue());
       }
    }
}
