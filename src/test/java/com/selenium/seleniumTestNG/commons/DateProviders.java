package com.selenium.seleniumTestNG.commons;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DateProviders {

//    @DataProvider
//    public Object[][] dataSet() {
//        Object[][] dataSet = new Object[4][2];
//        //first row
//        dataSet[0][0] = "user1";
//        dataSet[0][1] = "pass1";
//        //second row
//        dataSet[1][0] = "user2";
//        dataSet[1][1] = "pass2";
//        //third row
//        dataSet[2][0] = "user3";
//        dataSet[2][1] = "pass3";
//        //fourth row
//        dataSet[3][0] = "user4";
//        dataSet[3][1] = "pass4";
//
//        return dataSet;
//    }

    @DataProvider(name = "credentials")
    public Object[][] dataSet1(Method method) {
        return switch (method.getName()) {
            case "test" -> new Object[][]{
                    {"username", "password"},
                    {"username1", "password1"},
                    {"username2", "password2"}
            };
            case "test1" -> new Object[][]{
                    {"username", "password", "test"},
                    {"username1", "password1", "test1"},
                    {"username2", "password2", "test2"}
            };
            case "test2" -> new Object[][]{
                    {"username", "password", "test", "message"},
                    {"username1", "password1", "test1", "message1"},
                    {"username2", "password2", "test2", "message2"}
            };
            default -> null;
        };
    }

    @DataProvider(name = "credentialsSwabLags")
    public Object[][] credentials() {
        return new Object[][]
                {{"standard_user", "secret_sauce"},
                        {"problem_user", "secret_sauce"},
                        {"performance_glitch_user", "secret_sauce"}};
    }
}
