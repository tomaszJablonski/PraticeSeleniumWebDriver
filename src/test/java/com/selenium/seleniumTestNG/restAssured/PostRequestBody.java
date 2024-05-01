package com.selenium.seleniumTestNG.restAssured;

import io.restassured.http.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestBody {
    //json-server --watch students.json

    /*
    1)HashMap
    2)using org.json
    3)using POJO (Plain old Java Object)
    4)using external json file
     */

    @Test(priority = 1, enabled = false)
    public void postUsingHashMap() {
        /*
        {
        "id":3,
        "name":"Jonno",
        "location":"Spanish",
        "phone":"123456789",
        "courses":[
         "Java",
         "RestAssured"
        ]
        }
         */

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "Jonno");
        hashMap.put("location", "Spanish");
        hashMap.put("phone", "8541458245");

        String[] courseArr = {"Java", "RestAssured"};
        hashMap.put("courses", courseArr);

        given()
                .contentType("application/json")
                .body(hashMap)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Jonno"))
                .body("location", equalTo("Spanish"))
                .body("phone", equalTo("8541458245"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("RestAssured"))
                .header("Content-Type", "application/json")
                .log().all();
    }

    //deleting student record
    @Test(priority = 2, enabled = false)
    public void testDelete() {
        given()

                .when()
                .delete("http://localhost:3000/students/08a8")

                .then()
                .statusCode(200);
    }

    @Test(priority = 3, enabled = false)
    public void postOrgJsonLibrary() {
        /*
        need dependency org.json
        {
        "id":3,
        "name":"Jonno",
        "location":"Spanish",
        "phone":"123456789",
        "courses":[
         "Java",
         "RestAssured"
        ]
        }
         */

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Maria");
        jsonObject.put("location", "Poland");
        jsonObject.put("phone", "84641141545");

        String[] coursesArr = {"Java", "Selenium"};
        JSONArray jsonArrays = new JSONArray(coursesArr);
        jsonObject.put("courses", coursesArr);


        given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Maria"))
                .body("location", equalTo("Poland"))
                .body("phone", equalTo("84641141545"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Selenium"))
                .header("Content-Type", "application/json")
                .log().all();
    }

    @Test(priority = 4, enabled = false)
    public void postUsingPOJO() {

        PojoPostRequest pojoPostRequest = new PojoPostRequest();
        pojoPostRequest.setName("Bernard");
        pojoPostRequest.setLocation("Kalisz");
        pojoPostRequest.setPhone("34543543534");

        String[] coursesArray = {"Java", "Selenium"};
        pojoPostRequest.setCourses(coursesArray);


        given()
                .contentType("application/json")
                .body(pojoPostRequest)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Bernard"))
                .body("location", equalTo("Kalisz"))
                .body("phone", equalTo("34543543534"))
                .body("courses[0]", equalTo("Java"))
                .body("courses[1]", equalTo("Selenium"))
                .header("Content-Type", "application/json")
                .log().all();
    }

    @Test(priority = 4)
    public void postUsingExternalJsonFile() throws FileNotFoundException {

        File file = new File("src/test/java/com/selenium/seleniumTestNG/restAssured/testdata/body.json");

        FileReader fileReader = new FileReader(file);

        JSONTokener jsonTokener = new JSONTokener(fileReader);

        JSONObject jsonObject = new JSONObject(jsonTokener);

        given()
                .contentType("application/json")
                .body(jsonObject.toString())

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name", equalTo("Eleonora"))
                .body("location", equalTo("Poland"))
                .body("phone", equalTo("123456789"))
                .body("courses[0]", equalTo("java"))
                .body("courses[1]", equalTo("restAssured"))
                .header("Content-Type", "application/json")
                .log().all();
    }
}
