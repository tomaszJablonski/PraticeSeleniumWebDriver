package com.selenium.seleniumTestNG.restAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponse {
    //json-server store.json

    @Test(priority = 1, testName = "For small json")
    public void findAndEqualToInJsonSpecificDataInBody() {
        https:
//jsonpathfinder.com/
        given()
                .contentType(ContentType.JSON)

                .when()
                .get("http://localhost:3000/store")

                .then()
                .statusCode(200)
                .body("book[1].title", equalTo("Sword of Honor"));
    }

    @Test(priority = 2)
    public void findAndAssertJsonSpecificDataInBody() {
        Response response =
                given()
                        .contentType(ContentType.JSON)

                        .when()
                        .get("http://localhost:3000/store");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("book[1].title"), "Sword of Honor");
    }

    @Test(priority = 3)
    public void findAndAssertJsonSpecificDataInBodyInAllTheSameObject() {
        Response response =
                given()
                        .contentType(ContentType.JSON)

                        .when()
                        .get("http://localhost:3000/store");

        JSONObject jsonObject = new JSONObject(response.asString());

//        print all titles of the book
        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            String bookTitles = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();
            System.out.println(bookTitles);

        }

//        Szuka czy jest książka o podanym tytule w json
        boolean status = false;

        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            String bookTitles = jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();
            if (bookTitles.equals("Sword of Honor")) {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);

        //validate total price of books
        double totalPrice = 0;

        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            String booksPrice = jsonObject.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice = totalPrice + Double.parseDouble(booksPrice);
        }
        System.out.println("totalPrice = " + totalPrice);

        Assert.assertEquals(totalPrice,250.5);
    }
}
