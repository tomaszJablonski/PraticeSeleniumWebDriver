package com.selenium.seleniumTestNG.restAssured;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponseBody {

    //Bardzo Ważne !!!
    //.asString() jak chcemy przekonwertować całą odpowiedź na Stringa
    //.toString() jak chcemy jeden fragment odpowiedzi zamienić w Stringa

    @Test(priority = 1,enabled = false)
    public void testXMLResponseBody() {
        given()
                .when()
                .get("http://localhost:8081/petStore.xml")

                .then()
                .statusCode(200)
                .header("Content-Type", "application/xml")
                .body("pets.Pet.status[0]", equalTo("available"))
                .body("pets.Pet.category[0].name[0]", equalTo("string"))
                .body("pets.Pet.name[1]", equalTo("pepe"))
                .log().all();
    }

    @Test(enabled = false)
    public void testXMLVariableResponse() {
        Response response = given()

                .when()
                .get("http://localhost:8081/petStore.xml");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getHeader("Content-Type"), "application/xml");

        String status = response.xmlPath().get("pets.Pet.status[0]").toString();
        Assert.assertEquals(status, "available");

        String categoryName = response.xmlPath().get("pets.Pet.category[0].name[0]").toString();
        Assert.assertEquals(categoryName,"string");

        String petName = response.xmlPath().get("pets.Pet.name[1]").toString();
        Assert.assertEquals(petName,"pepe");
    }

    @Test
    public void testXMLVariableResponseBody() {
        Response response = given()

                .when()
                .get("http://localhost:8081/petStore.xml");

        XmlPath xmlPathObject = new XmlPath(response.asString());
        //Verify total number of pets
        List<String> pets = xmlPathObject.getList("pets.Pet");
        Assert.assertEquals(pets.size(),330);

        //Verify pet name is present in response
        List<String> petsName = xmlPathObject.getList("pets.Pet.name");
        boolean status = false;
        for(String petName:petsName){
//            System.out.println(petName);
            if(petName.equals("pepe")){
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);
    }
}