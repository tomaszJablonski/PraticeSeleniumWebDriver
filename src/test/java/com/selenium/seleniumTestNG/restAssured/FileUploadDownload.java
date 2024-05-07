package com.selenium.seleniumTestNG.restAssured;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FileUploadDownload {

    @Test(enabled = false)
    public void singleFileUpload() {
        File myFile = new File("X:\\RestAssured\\uploadFile.txt");
        given()
                .multiPart("file", myFile)
                .contentType("multipart/form-data")

                .when()
                .post("http://localhost:8080/uploadFile")


                .then()
                .statusCode(200)
                .body("fileName", equalTo("uploadFile.txt"))
                .log().all();
    }

    @Test(enabled = false)
    public void multipleFileUpload() {
        File myFile = new File("X:\\RestAssured\\uploadFile.txt");
        File myFile2 = new File("X:\\RestAssured\\uploadFile1.txt");

        given()
                .multiPart("files", myFile)
                .multiPart("files", myFile2)
                .contentType("multipart/form-data")

                .when()
                .post("http://localhost:8080/uploadMultiplaFiles")

                .then()
                .statusCode(200)
                .body("[0].fileName", equalTo("uploadFile.txt"))
                .body("[1].fileName", equalTo("uploadFile1.txt"))
                .log().all();
    }

    @Test(enabled = false)
    public void multipleFileUpload2() {
        File myFile = new File("X:\\RestAssured\\uploadFile.txt");
        File myFile2 = new File("X:\\RestAssured\\uploadFile1.txt");

        File fileArray[] = {myFile,myFile2};

        given()
                .multiPart("files",fileArray)
                .contentType("multipart/form-data")

                .when()
                .post("http://localhost:8080/uploadMultiplaFiles")

                .then()
                .statusCode(200)
                .body("[0].fileName", equalTo("uploadFile.txt"))
                .body("[1].fileName", equalTo("uploadFile1.txt"))
                .log().all();
    }

    @Test(enabled = false)
    public void downloadFile(){
        given()

                .when()
                .get("http://localhost:8080/uploadMultiplaFiles")
                .then()
                .statusCode(200)
                .log().body();
    }
}