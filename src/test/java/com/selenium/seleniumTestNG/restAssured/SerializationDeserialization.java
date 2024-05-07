package com.selenium.seleniumTestNG.restAssured;


// Pojo ---Serialization---> Json Object ---De-serialization---> Pojo

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SerializationDeserialization {

    //nie musze tego robić w RestAssured bo to się dzieje automatycznie
    // - to jest nauka żeby zrozumieć proces
    // Pojo -----> JSON (Serialization)
    @Test
    public void convertPojoToJson() throws JsonProcessingException {
        //created java object using pojo class
        PojoPostRequest pojoPostRequest = new PojoPostRequest();
        pojoPostRequest.setName("Franczeska");
        pojoPostRequest.setPhone("84165486888");
        pojoPostRequest.setLocation("France");
        String[] stringArr = {"Java", "RestAssured"};
        pojoPostRequest.setCourses(stringArr);

        //convert java object ---> json object (serialization)

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojoPostRequest);
        System.out.println(jsonData);

    }

    // JSON -------> Pojo (Deserialization)
    @Test(priority = 2)
    public void convertJsonToPojo() throws JsonProcessingException {
//        {
//            "name" : "Franczeska",
//                "location" : "France",
//                "phone" : "84165486888",
//                "courses" : [ "Java", "RestAssured" ]
//        }

        String jsonData = "{\n" +
                "  \"name\" : \"Franczeska\",\n" +
                "  \"location\" : \"France\",\n" +
                "  \"phone\" : \"84165486888\",\n" +
                "  \"courses\" : [ \"Java\", \"RestAssured\" ]\n" +
                "}";

        //convert Json Data ----> Pojo Object

        ObjectMapper objectMapper = new ObjectMapper();
        //convert json to pojo class
        PojoPostRequest pojoPostRequest = objectMapper.readValue(jsonData, PojoPostRequest.class);
        System.out.println("pojoPostRequest.getName() = " + pojoPostRequest.getName());
        System.out.println("pojoPostRequest.getLocation() = " + pojoPostRequest.getLocation());
        System.out.println("pojoPostRequest.getPhone() = " + pojoPostRequest.getPhone());
        System.out.println("pojoPostRequest.getCourses() = " + Arrays.toString(pojoPostRequest.getCourses()));
        //or
        System.out.println("pojoPostRequest.getCourses()[0] = " + pojoPostRequest.getCourses()[0]);
        System.out.println("pojoPostRequest.getCourses()[1] = " + pojoPostRequest.getCourses()[1]);
    }
}