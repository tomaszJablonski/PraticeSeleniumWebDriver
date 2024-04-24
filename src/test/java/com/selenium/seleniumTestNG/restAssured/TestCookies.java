package com.selenium.seleniumTestNG.restAssured;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestCookies {

    @Test(priority = 1, enabled = false)
    public void testCookies() {
        given()

                .when()
                .get("https://www.google.pl/")

                .then()
                .cookie("AEC", "AQTF6Hw_X8Ah2jhpZf-hF6rvmb4kR69uKStsKkDuWv1Nkwgqnc5S0iKnnRA")
                .log().all();
    }

    @Test(priority = 2)
    public void getCookiesInfo() {
        //jeżeli chcemy zapisać response to nie można używać then !!
        Response response = given()

                .when()
                .get("https://www.google.pl/");

        // get value single cookie info
//        String cookieValue = response.getCookie("AEC");
//        System.out.println("Value of AEC cookie is ===>" + cookieValue);

        //get value of all cookies info

        Map<String, String> cookiesValues = response.getCookies();
        //only keys
        //System.out.println(cookiesValues.keySet());

        for (String keys : cookiesValues.keySet()){
            String cookieValue = response.getCookie(keys);
            System.out.println("Keys cookie:" + keys + "      " + " value:" + cookieValue );
        }
    }
}