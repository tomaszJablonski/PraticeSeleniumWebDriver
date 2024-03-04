package com.selenium.seleniumTestNG.commons;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {

    @BeforeSuite
    public void dataSetup() {
        System.out.println("******Common data setup");
    }

    @AfterSuite
    public void dataTearDown() {
        System.out.println("******Common data cleanup");
    }

}