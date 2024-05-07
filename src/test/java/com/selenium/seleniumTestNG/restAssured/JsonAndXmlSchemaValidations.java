package com.selenium.seleniumTestNG.restAssured;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

//data in resources
public class JsonAndXmlSchemaValidations {

    @Test(enabled = false)
    public void jsonSchemaValidation(){
        given()

                .when()
                .get("http://localhost:3000/store")

                .then()
                //w tej metodzie szuka w resources nazwy pliku który jest wpisany
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaValidationRestAssured.json"));
    }

    @Test
    public void xmlSchemaValidation(){
        given()

                .when()
                .get("http://localhost:8081/petStoreForSchemaValidation.xml")

                .then()
                //w tej metodzie szuka w resources nazwy pliku który jest wpisany
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchemaValidation.xsd"));
    }
}
