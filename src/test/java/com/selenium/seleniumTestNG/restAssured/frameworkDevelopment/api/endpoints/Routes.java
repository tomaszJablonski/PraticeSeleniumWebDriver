package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.endpoints;

/*
Swagger - https://petstore.swagger.io - base url /xxx - endpoint

POST - https://petstore.swagger.io/v2/user
GET - https://petstore.swagger.io/v2/user/{username}
PUT - https://petstore.swagger.io/v2/user/{username}
DELETE - https://petstore.swagger.io/v2/user/{username}
 */

//All urls in this class
public class Routes {

    public static String base_url = "https://petstore.swagger.io/v2";

    //User module

    public static String post_url = base_url + "/user";
    public static String get_url = base_url + "/user/{username}";
    public static String update_url = base_url + "/user/{username}";
    public static String delete_url = base_url + "/user/{username}";

    //Store module
        //here create Store module url`s

    //Pet module
        //here create Pet module url`s
}
