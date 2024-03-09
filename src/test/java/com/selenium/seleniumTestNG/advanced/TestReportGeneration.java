package com.selenium.seleniumTestNG.advanced;


import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestReportGeneration {

    @Test
    public void reporterTest1(){
        Reporter.log("This is test1");
        System.out.println("This is test1");
    }

    @Test
    public void reporterTest2(){
        System.out.println("This is test2");
    }

    @Test
    public void reporterTest3(){
        System.out.println("This is test3");
    }

    @Test
    public void reporterTest4(){
        System.out.println("This is test4");
    }
}
