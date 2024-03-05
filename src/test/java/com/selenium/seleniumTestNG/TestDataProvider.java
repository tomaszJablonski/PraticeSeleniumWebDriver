package com.selenium.seleniumTestNG;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {

    @Test(dataProvider = "dataSet")
    public void test(String username, String password) {
        System.out.println(username + " " + password);
    }

    @DataProvider
    public Object[][] dataSet() {
        Object[][] dataSet = new Object[4][2];
        //first row
        dataSet[0][0] = "user1";
        dataSet[0][1] = "pass1";
        //second row
        dataSet[1][0] = "user2";
        dataSet[1][1] = "pass2";
        //third row
        dataSet[2][0] = "user3";
        dataSet[2][1] = "pass3";
        //fourth row
        dataSet[3][0] = "user4";
        dataSet[3][1] = "pass4";

        return dataSet;
    }

    @Test(dataProvider = "credentials")
    public void test1(String username, String password, String test) {
        System.out.println(username + " " + password + " " + test);
    }

    @DataProvider(name = "credentials")
    public Object[][] dataSet1() {

        return new Object[][]
                {{"username", "password", "test"},
                        {"username1", "password1", "test1"},
                        {"username2", "password2", "test2"}};
    }


}

